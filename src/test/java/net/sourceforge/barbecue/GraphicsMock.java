/***********************************************************************************************************************
Copyright (c) 2003, International Barcode Consortium
All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this list of
      conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of
      conditions and the following disclaimer in the documentation and/or other materials
      provided with the distribution.
 * Neither the name of the International Barcode Consortium nor the names of any contributors may be used to endorse
      or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY
AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
POSSIBILITY OF SUCH DAMAGE.
 ***********************************************************************************************************************/

package net.sourceforge.barbecue;

import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GraphicsMock extends Graphics2D {
	private List<Color> colors;
	private List<Rectangle> rects;
	private int maxX;
	private int maxY;
	private int minY;
	private int minX;
	private boolean maxSet;
	private boolean minSet;
	private Rectangle textBounds;
	private Color currentColor;
	private List<String> strings;
	private boolean textDrawn;

	public GraphicsMock() {
		init();
	}

	public void reset() {
		init();
	}

	private void init() {
		this.colors = new ArrayList<>();
		this.rects = new ArrayList<>();
		this.strings = new ArrayList<>();
		this.currentColor = Color.black;
		this.minSet = false;
		this.maxSet = false;
		this.textDrawn = false;
	}

	public Rectangle getTextBounds() {
		return textBounds;
	}

	public Rectangle getModifiedBounds() {
		return new Rectangle(minX, minY, maxX, maxY);
	}

	public List<Color> getColors() {
		return colors;
	}

	public List<Rectangle> getRects() {
		return rects;
	}

	@Override
	public void draw(final Shape s) {
	}

	@Override
	public boolean drawImage(final Image img,
			final AffineTransform xform,
			final ImageObserver obs) {
		return false;
	}

	@Override
	public void drawImage(final BufferedImage img,
			final BufferedImageOp op,
			final int x,
			final int y) {
		updateMin(x, y);
		updateMax(x, y);
	}

	@Override
	public void drawRenderedImage(final RenderedImage img,
			final AffineTransform xform) {
	}

	@Override
	public void drawRenderableImage(final RenderableImage img,
			final AffineTransform xform) {
	}

	@Override
	public void drawString(final String str, final int x, final int y) {
		updateMin(x, y);
		updateMax(x, y);
		textBounds = new Rectangle(x, y, x, y);
		strings.add(str);
		textDrawn = true;
	}

	@Override
	public void drawString(final String s, final float x, final float y) {
		updateMin(x, y);
		updateMax((int)x, (int)y);
		textBounds = new Rectangle((int) x, (int) y, (int) x, (int) y);
		strings.add(s);
		textDrawn = true;
	}

	@Override
	public void drawString(final AttributedCharacterIterator iterator,
			final int x, final int y) {
		updateMin(x, y);
		updateMax(x, y);
		textBounds = new Rectangle(x, y, x, y);
		textDrawn = true;
	}

	@Override
	public void drawString(final AttributedCharacterIterator iterator,
			final float x, final float y) {
		updateMin(x, y);
		updateMax((int)x, (int)y);
		textBounds = new Rectangle((int) x, (int) y, (int) x, (int) y);
		textDrawn = true;
	}

	@Override
	public void drawGlyphVector(final GlyphVector g, final float x, final float y) {
		updateMin(x, y);
		updateMax(x, y);
		textBounds = new Rectangle((int) x, (int) y, (int) x, (int) y);
		textDrawn = true;
	}

	@Override
	public void fill(final Shape s) {
	}

	@Override
	public boolean hit(final Rectangle rect,
			final Shape s,
			final boolean onStroke) {
		return false;
	}

	@Override
	public GraphicsConfiguration getDeviceConfiguration() {
		return null;
	}

	@Override
	public void setComposite(final Composite comp) {
	}

	@Override
	public void setPaint(final Paint paint) {
	}

	@Override
	public void setStroke(final Stroke s) {
	}

	@Override
	public void setRenderingHint(final RenderingHints.Key hintKey, final Object hintValue) {
	}

	@Override
	public Object getRenderingHint(final RenderingHints.Key hintKey) {
		return null;
	}

	@Override
	public void setRenderingHints(final Map<?,?> hints) {
	}

	@Override
	public void addRenderingHints(final Map<?,?> hints) {
	}

	@Override
	public RenderingHints getRenderingHints() {
		return null;
	}

	@Override
	public void translate(final int x, final int y) {
	}

	@Override
	public void translate(final double tx, final double ty) {
	}

	@Override
	public void rotate(final double theta) {
	}

	@Override
	public void rotate(final double theta, final double x, final double y) {
	}

	@Override
	public void scale(final double sx, final double sy) {
	}

	@Override
	public void shear(final double shx, final double shy) {
	}

	@Override
	public void transform(final AffineTransform Tx) {
	}

	@Override
	public void setTransform(final AffineTransform Tx) {
	}

	@Override
	public AffineTransform getTransform() {
		return null;
	}

	@Override
	public Paint getPaint() {
		return null;
	}

	@Override
	public Composite getComposite() {
		return null;
	}

	@Override
	public void setBackground(final Color color) {
	}

	@Override
	public Color getBackground() {
		return null;
	}

	@Override
	public Stroke getStroke() {
		return null;
	}

	@Override
	public void clip(final Shape s) {
	}

	@Override
	public FontRenderContext getFontRenderContext() {
		return new FontRenderContext(new AffineTransform(1, 0, 0, 1, 0, 0), false, false);
	}

	@Override
	public Graphics create() {
		return null;
	}

	@Override
	public Color getColor() {
		return currentColor;
	}

	@Override
	public void setColor(final Color c) {
		currentColor = c;
		colors.add(c);
	}

	@Override
	public void setPaintMode() {
	}

	@Override
	public void setXORMode(final Color c1) {
	}

	@Override
	public Font getFont() {
		return null;
	}

	@Override
	public void setFont(final Font font) {
	}

	@Override
	public FontMetrics getFontMetrics(final Font f) {
		return null;
	}

	@Override
	public Rectangle getClipBounds() {
		return null;
	}

	@Override
	public void clipRect(final int x, final int y, final int width, final int height) {
	}

	@Override
	public void setClip(final int x, final int y, final int width, final int height) {
	}

	@Override
	public Shape getClip() {
		return null;
	}

	@Override
	public void setClip(final Shape clip) {
	}

	@Override
	public void copyArea(final int x, final int y, final int width, final int height,
			final int dx, final int dy) {
	}

	@Override
	public void drawLine(final int x1, final int y1, final int x2, final int y2) {
		updateMin(x1, y1);
		updateMax(x2, y2);
	}

	@Override
	public void fillRect(final int x, final int y, final int width, final int height) {
		rects.add(new Rectangle(x, y, width, height));
		updateMin(x, y);
		updateMax(x + width, y + height);
	}

	@Override
	public void clearRect(final int x, final int y, final int width, final int height) {
		updateMin(x, y);
		updateMax(x + width, y + height);
	}

	@Override
	public void drawRoundRect(final int x, final int y, final int width, final int height,
			final int arcWidth, final int arcHeight) {
		updateMin(x, y);
		updateMax(x + width, y + height);
	}

	@Override
	public void fillRoundRect(final int x, final int y, final int width, final int height,
			final int arcWidth, final int arcHeight) {
		updateMin(x, y);
		updateMax(x + width, y + height);
	}

	@Override
	public void drawOval(final int x, final int y, final int width, final int height) {
		updateMin(x, y);
		updateMax(x + width, y + height);
	}

	@Override
	public void fillOval(final int x, final int y, final int width, final int height) {
		updateMin(x, y);
		updateMax(x + width, y + height);
	}

	@Override
	public void drawArc(final int x, final int y, final int width, final int height,
			final int startAngle, final int arcAngle) {
		updateMin(x, y);
		updateMax(x + width, y + height);
	}

	@Override
	public void fillArc(final int x, final int y, final int width, final int height,
			final int startAngle, final int arcAngle) {
		updateMin(x, y);
		updateMax(x + width, y + height);
	}

	@Override
	public void drawPolyline(final int xPoints[], final int yPoints[],
			final int nPoints) {
		for (int i=0; i<nPoints; i++) {
			updateMin(xPoints[i], yPoints[i]);
			updateMax(xPoints[i], yPoints[i]);
		}
	}

	@Override
	public void drawPolygon(final int xPoints[], final int yPoints[],
			final int nPoints) {
		for (int i=0; i<nPoints; i++) {
			updateMin(xPoints[i], yPoints[i]);
			updateMax(xPoints[i], yPoints[i]);
		}
	}

	@Override
	public void fillPolygon(final int xPoints[], final int yPoints[],
			final int nPoints) {
		for (int i=0; i<nPoints; i++) {
			updateMin(xPoints[i], yPoints[i]);
			updateMax(xPoints[i], yPoints[i]);
		}
	}

	@Override
	public boolean drawImage(final Image img, final int x, final int y,
			final ImageObserver observer) {
		updateMin(x, y);
		return false;
	}

	@Override
	public boolean drawImage(final Image img, final int x, final int y,
			final int width, final int height,
			final ImageObserver observer) {
		updateMin(x, y);
		updateMax(x + width, y + height);
		return false;
	}

	@Override
	public boolean drawImage(final Image img, final int x, final int y,
			final Color bgcolor,
			final ImageObserver observer) {
		updateMin(x, y);
		return false;
	}

	@Override
	public boolean drawImage(final Image img, final int x, final int y,
			final int width, final int height,
			final Color bgcolor,
			final ImageObserver observer) {
		updateMin(x, y);
		updateMax(x + width, y + height);
		return false;
	}

	@Override
	public boolean drawImage(final Image img,
			final int dx1, final int dy1, final int dx2, final int dy2,
			final int sx1, final int sy1, final int sx2, final int sy2,
			final ImageObserver observer) {
		return false;
	}

	@Override
	public boolean drawImage(final Image img,
			final int dx1, final int dy1, final int dx2, final int dy2,
			final int sx1, final int sy1, final int sx2, final int sy2,
			final Color bgcolor,
			final ImageObserver observer) {
		return false;
	}

	@Override
	public void dispose() {
	}

	private void updateMin(final float x, final float y) {
		updateMin((int) x, (int) y);
	}

	private void updateMin(final int x, final int y) {
		if (! minSet) {
			minX = x;
			minY = y;
			minSet = true;
		} else {
			if (x < minX) {
				minX = x;
			}
			if (y < minY) {
				minY = y;
			}
		}
	}

	private void updateMax(final float x, final float y) {
		updateMax((int) x, (int) y);
	}

	private void updateMax(final int x, final int y) {
		if (! maxSet) {
			maxX = x;
			maxY = y;
			maxSet = true;
		} else {
			if (x > maxX) {
				maxX = x;
			}
			if (y > maxY) {
				maxY = y;
			}
		}
	}

	public List<String> getStrings() {
		return strings;
	}

	public boolean wasTextDrawn() {
		return textDrawn;
	}
}
