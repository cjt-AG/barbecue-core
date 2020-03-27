package net.sourceforge.barbecue.linear;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.font.TextLayout;
import java.util.List;

import junit.framework.TestCase;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BlankModule;
import net.sourceforge.barbecue.GraphicsMock;
import net.sourceforge.barbecue.Module;
import net.sourceforge.barbecue.env.DefaultEnvironment;
import net.sourceforge.barbecue.output.CenteredLabelLayout;
import net.sourceforge.barbecue.output.GraphicsOutput;
import net.sourceforge.barbecue.output.Output;
import net.sourceforge.barbecue.output.OutputException;

public class LinearBarcodeTest extends TestCase {

	public void testDrawMakesCorrectCallbacksForDefaultMode() throws Exception {
		BarcodeMock barcode = new BarcodeMock("12345");
		barcode.draw(new GraphicsOutput(new GraphicsMock(), null, Color.black, Color.white), 0, 0, 1, 50);
		assertTrue(barcode.isCalculatedCheckDigit());
		assertTrue(barcode.isEncodedData());
		assertTrue(barcode.isGotPostamble());
		assertTrue(barcode.isGotPreamble());
	}

	public void testBarcodeDoesNotTouchGraphicsOutsideOfBounds() throws Exception {
		BarcodeMock barcode = new BarcodeMock("12345");
		GraphicsMock g = new GraphicsMock();
		barcode.draw(g, 0, 0);
		Rectangle bounds = barcode.getBounds();
		Rectangle drawn = g.getModifiedBounds();
		assertEquals(drawn, bounds);
	}

	public void testBarcodeWithNoTextDoesNotTouchGraphicsOutsideOfBoundsForNonOriginDraw() throws Exception {
		BarcodeMock barcode = new BarcodeMock("12345");
		barcode.setDrawingText(false);
		GraphicsMock g = new GraphicsMock();
		barcode.draw(g, 15, 133);
		Rectangle bounds = barcode.getBounds();
		Rectangle drawn = g.getModifiedBounds();
		assertEquals(drawn, bounds);
	}

	public void testBarcodeDoesNotTouchGraphicsOutsideOfBoundsForNonOriginDraw() throws Exception {
		BarcodeMock barcode = new BarcodeMock("12345");
		GraphicsMock g = new GraphicsMock();
		barcode.draw(g, 15, 133);
		Rectangle bounds = barcode.getBounds();
		Rectangle drawn = g.getModifiedBounds();
		assertEquals(bounds, drawn);
	}

	public void testTextIsPositionedCorrectly() throws Exception {
		int barHeight = 100;
		while (barHeight < 1000) {
			BarcodeMock barcode = new BarcodeMock("12345");
			barcode.setBarHeight(barHeight);
			GraphicsMock g = new GraphicsMock();
			barcode.output(new GraphicsOutput(g, DefaultEnvironment.DEFAULT_FONT, Color.black, Color.white));
			TextLayout layout = new TextLayout("12345", DefaultEnvironment.DEFAULT_FONT, g.getFontRenderContext());
			final Rectangle textBounds = g.getTextBounds();
			int textStart = 0;
			if (textBounds != null) {
				textStart = (int) textBounds.getY();
			}
			assertEquals((int) (barHeight + layout.getBounds().getHeight() + CenteredLabelLayout.BARS_TEXT_VGAP), textStart);
			barHeight += 100;
		}
	}

	public void testTextIsDrawnCentered() throws Exception {
		BarcodeMock barcode = new BarcodeMock("12345");
		GraphicsMock g = new GraphicsMock();
		barcode.draw(g, 0, 0);
		int width = barcode.getWidth();
		Rectangle textBounds = g.getTextBounds();
		double x = 0;
		if (textBounds != null) {
			x = textBounds.getX();
		}
		assertTrue(x > 0);
		assertTrue(x < width / 2);
	}

	public void testBarcodeIsDrawnAtCorrectStartingPointForNonOriginDraw() throws Exception {
		BarcodeMock barcode = new BarcodeMock("12345");
		GraphicsMock g = new GraphicsMock();
		barcode.draw(g, 54, 37);
		assertEquals(54, (int) g.getModifiedBounds().getX());
		assertEquals(37, (int) g.getModifiedBounds().getY());
	}

	public void testTextIsDrawnBlackOnWhiteByDefault() throws Exception {
		TextOnlyBarcode barcode = new TextOnlyBarcode("12345");
		GraphicsMock g = new GraphicsMock();
		barcode.draw(g, 54, 37);
		List<Color> colors = g.getColors();
		assertEquals(3, colors.size());
		assertEquals(barcode.getForeground(), colors.get(1));
		assertTrue(barcode.textDrawn);
		assertTrue(g.wasTextDrawn());
	}

	public class TextOnlyBarcode extends LinearBarcode {
		private boolean textDrawn;

		public TextOnlyBarcode(final String data) throws BarcodeException {
			super(data);
		}

		@Override
		protected Module calculateChecksum() {
			return null;
		}

		@Override
		protected Module[] encodeData() {
			return new Module[0];
		}

		@Override
		protected Module getPostAmble() {
			return null;
		}

		@Override
		protected Module getPreAmble() {
			return null;
		}

		@Override
		protected int drawTextLabel(final Output params, final int x, final int y, final int width) throws OutputException {
			textDrawn = true;
			return super.drawTextLabel(params, x, y, width);
		}
	}

	public class BarcodeMock extends LinearBarcode {
		private boolean encodedData = false;
		private boolean calculatedCheckDigit = false;
		private boolean gotPreamble = false;
		private boolean gotPostamble = false;

		public BarcodeMock(final String data) throws BarcodeException {
			this(data, true);
		}

		public BarcodeMock(final String data, final boolean drawText) throws BarcodeException {
			super(data);
			drawingText = drawText;
		}

		protected double getBarcodeWidth(final int resolution) {
			return 0;
		}

		@Override
		protected Module[] encodeData() {
			encodedData = true;
			return new Module[] {new Module( new int[] {2, 1, 1, 2, 4} )};
		}

		@Override
		protected Module calculateChecksum() {
			calculatedCheckDigit = true;
			return new BlankModule(0);
		}

		@Override
		protected Module getPreAmble() {
			gotPreamble = true;
			return new BlankModule(0);
		}

		@Override
		protected Module getPostAmble() {
			gotPostamble = true;
			return new BlankModule(0);
		}

		public boolean isEncodedData() {
			return encodedData;
		}

		public boolean isCalculatedCheckDigit() {
			return calculatedCheckDigit;
		}

		public boolean isGotPreamble() {
			return gotPreamble;
		}

		public boolean isGotPostamble() {
			return gotPostamble;
		}
	}
}
