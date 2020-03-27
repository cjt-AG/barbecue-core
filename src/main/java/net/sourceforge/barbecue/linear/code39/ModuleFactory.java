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

package net.sourceforge.barbecue.linear.code39;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sourceforge.barbecue.Module;

/**
 * The Code 39 barcode module definitions.
 *
 * @author <a href="mailto:opensource@ianbourke.com">Ian Bourke</a>
 */
public final class ModuleFactory {

	/**
	 * The start and stop character for the barcode
	 */
	public static final Module START_STOP = new Module(new int[]{1, 2, 1, 1, 2, 1, 2, 1, 1});

	private static final List<String> KEYS = new ArrayList<>();
	private static final Map<String, Module> SET = new HashMap<>();
	private static final Map<Character, String> EXT_CHARS = new HashMap<>();
	private static final List<String> ESCAPE_CHARS = new ArrayList<>();

	static {
		initBaseSet();
		initExtendedSet();
	}

	///CLOVER:OFF
	/**
	 * Cannot construct.
	 */
	private ModuleFactory() {
	}
	///CLOVER:ON

	/**
	 * Initialise the module definitions.
	 */
	private static void initBaseSet() {
		KEYS.add("0");
		SET.put("0", new Module(new int[]{1, 1, 1, 2, 2, 1, 2, 1, 1}));
		KEYS.add("1");
		SET.put("1", new Module(new int[]{2, 1, 1, 2, 1, 1, 1, 1, 2}));
		KEYS.add("2");
		SET.put("2", new Module(new int[]{1, 1, 2, 2, 1, 1, 1, 1, 2}));
		KEYS.add("3");
		SET.put("3", new Module(new int[]{2, 1, 2, 2, 1, 1, 1, 1, 1}));
		KEYS.add("4");
		SET.put("4", new Module(new int[]{1, 1, 1, 2, 2, 1, 1, 1, 2}));
		KEYS.add("5");
		SET.put("5", new Module(new int[]{2, 1, 1, 2, 2, 1, 1, 1, 1}));
		KEYS.add("6");
		SET.put("6", new Module(new int[]{1, 1, 2, 2, 2, 1, 1, 1, 1}));
		KEYS.add("7");
		SET.put("7", new Module(new int[]{1, 1, 1, 2, 1, 1, 2, 1, 2}));
		KEYS.add("8");
		SET.put("8", new Module(new int[]{2, 1, 1, 2, 1, 1, 2, 1, 1}));
		KEYS.add("9");
		SET.put("9", new Module(new int[]{1, 1, 2, 2, 1, 1, 2, 1, 1}));
		KEYS.add("A");
		SET.put("A", new Module(new int[]{2, 1, 1, 1, 1, 2, 1, 1, 2}));
		KEYS.add("B");
		SET.put("B", new Module(new int[]{1, 1, 2, 1, 1, 2, 1, 1, 2}));
		KEYS.add("C");
		SET.put("C", new Module(new int[]{2, 1, 2, 1, 1, 2, 1, 1, 1}));
		KEYS.add("D");
		SET.put("D", new Module(new int[]{1, 1, 1, 1, 2, 2, 1, 1, 2}));
		KEYS.add("E");
		SET.put("E", new Module(new int[]{2, 1, 1, 1, 2, 2, 1, 1, 1}));
		KEYS.add("F");
		SET.put("F", new Module(new int[]{1, 1, 2, 1, 2, 2, 1, 1, 1}));
		KEYS.add("G");
		SET.put("G", new Module(new int[]{1, 1, 1, 1, 1, 2, 2, 1, 2}));
		KEYS.add("H");
		SET.put("H", new Module(new int[]{2, 1, 1, 1, 1, 2, 2, 1, 1}));
		KEYS.add("I");
		SET.put("I", new Module(new int[]{1, 1, 2, 1, 1, 2, 2, 1, 1}));
		KEYS.add("J");
		SET.put("J", new Module(new int[]{1, 1, 1, 1, 2, 2, 2, 1, 1}));
		KEYS.add("K");
		SET.put("K", new Module(new int[]{2, 1, 1, 1, 1, 1, 1, 2, 2}));
		KEYS.add("L");
		SET.put("L", new Module(new int[]{1, 1, 2, 1, 1, 1, 1, 2, 2}));
		KEYS.add("M");
		SET.put("M", new Module(new int[]{2, 1, 2, 1, 1, 1, 1, 2, 1}));
		KEYS.add("N");
		SET.put("N", new Module(new int[]{1, 1, 1, 1, 2, 1, 1, 2, 2}));
		KEYS.add("O");
		SET.put("O", new Module(new int[]{2, 1, 1, 1, 2, 1, 1, 2, 1}));
		KEYS.add("P");
		SET.put("P", new Module(new int[]{1, 1, 2, 1, 2, 1, 1, 2, 1}));
		KEYS.add("Q");
		SET.put("Q", new Module(new int[]{1, 1, 1, 1, 1, 1, 2, 2, 2}));
		KEYS.add("R");
		SET.put("R", new Module(new int[]{2, 1, 1, 1, 1, 1, 2, 2, 1}));
		KEYS.add("S");
		SET.put("S", new Module(new int[]{1, 1, 2, 1, 1, 1, 2, 2, 1}));
		KEYS.add("T");
		SET.put("T", new Module(new int[]{1, 1, 1, 1, 2, 1, 2, 2, 1}));
		KEYS.add("U");
		SET.put("U", new Module(new int[]{2, 2, 1, 1, 1, 1, 1, 1, 2}));
		KEYS.add("V");
		SET.put("V", new Module(new int[]{1, 2, 2, 1, 1, 1, 1, 1, 2}));
		KEYS.add("W");
		SET.put("W", new Module(new int[]{2, 2, 2, 1, 1, 1, 1, 1, 1}));
		KEYS.add("X");
		SET.put("X", new Module(new int[]{1, 2, 1, 1, 2, 1, 1, 1, 2}));
		KEYS.add("Y");
		SET.put("Y", new Module(new int[]{2, 2, 1, 1, 2, 1, 1, 1, 1}));
		KEYS.add("Z");
		SET.put("Z", new Module(new int[]{1, 2, 2, 1, 2, 1, 1, 1, 1}));
		KEYS.add("-");
		SET.put("-", new Module(new int[]{1, 2, 1, 1, 1, 1, 2, 1, 2}));
		KEYS.add(".");
		SET.put(".", new Module(new int[]{2, 2, 1, 1, 1, 1, 2, 1, 1}));
		KEYS.add(" ");
		SET.put(" ", new Module(new int[]{1, 2, 2, 1, 1, 1, 2, 1, 1}));
		KEYS.add("$");
		SET.put("$", new Module(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 1}));
		KEYS.add("/");
		SET.put("/", new Module(new int[]{1, 2, 1, 2, 1, 1, 1, 2, 1}));
		KEYS.add("+");
		SET.put("+", new Module(new int[]{1, 2, 1, 1, 1, 2, 1, 2, 1}));
		KEYS.add("%");
		SET.put("%", new Module(new int[]{1, 1, 1, 2, 1, 2, 1, 2, 1}));
	}

	/**
	 * Initialise the extended ASCII set lookup table.
	 */
	private static void initExtendedSet() {
		ESCAPE_CHARS.add("$");
		ESCAPE_CHARS.add("/");
		ESCAPE_CHARS.add("+");
		ESCAPE_CHARS.add("%");

		EXT_CHARS.put(Character.valueOf('\000'), "%U");
		EXT_CHARS.put(Character.valueOf('\001'), "$A");
		EXT_CHARS.put(Character.valueOf('\002'), "$B");
		EXT_CHARS.put(Character.valueOf('\003'), "$C");
		EXT_CHARS.put(Character.valueOf('\004'), "$D");
		EXT_CHARS.put(Character.valueOf('\005'), "$E");
		EXT_CHARS.put(Character.valueOf('\006'), "$F");
		EXT_CHARS.put(Character.valueOf('\007'), "$G");
		EXT_CHARS.put(Character.valueOf('\010'), "$H");
		EXT_CHARS.put(Character.valueOf('\011'), "$I");
		EXT_CHARS.put(Character.valueOf('\012'), "$J");
		EXT_CHARS.put(Character.valueOf('\013'), "$K");
		EXT_CHARS.put(Character.valueOf('\014'), "$L");
		EXT_CHARS.put(Character.valueOf('\015'), "$M");
		EXT_CHARS.put(Character.valueOf('\016'), "$N");
		EXT_CHARS.put(Character.valueOf('\017'), "$O");
		EXT_CHARS.put(Character.valueOf('\020'), "$P");
		EXT_CHARS.put(Character.valueOf('\021'), "$Q");
		EXT_CHARS.put(Character.valueOf('\022'), "$R");
		EXT_CHARS.put(Character.valueOf('\023'), "$S");
		EXT_CHARS.put(Character.valueOf('\024'), "$T");
		EXT_CHARS.put(Character.valueOf('\025'), "$U");
		EXT_CHARS.put(Character.valueOf('\026'), "$V");
		EXT_CHARS.put(Character.valueOf('\027'), "$W");
		EXT_CHARS.put(Character.valueOf('\030'), "$X");
		EXT_CHARS.put(Character.valueOf('\031'), "$Y");
		EXT_CHARS.put(Character.valueOf('\032'), "$Z");
		EXT_CHARS.put(Character.valueOf('\033'), "%A");
		EXT_CHARS.put(Character.valueOf('\034'), "%B");
		EXT_CHARS.put(Character.valueOf('\035'), "%C");
		EXT_CHARS.put(Character.valueOf('\036'), "%D");
		EXT_CHARS.put(Character.valueOf('\037'), "%E");
		EXT_CHARS.put(Character.valueOf('\177'), "%T"); // Also %X, %Y, %Z

		EXT_CHARS.put(Character.valueOf('!'), "/A");
		EXT_CHARS.put(Character.valueOf('"'), "/B");
		EXT_CHARS.put(Character.valueOf('#'), "/C");
		EXT_CHARS.put(Character.valueOf('$'), "/D");
		EXT_CHARS.put(Character.valueOf('%'), "/E");
		EXT_CHARS.put(Character.valueOf('&'), "/F");
		EXT_CHARS.put(Character.valueOf('\''), "/G");
		EXT_CHARS.put(Character.valueOf('('), "/H");
		EXT_CHARS.put(Character.valueOf(')'), "/I");
		EXT_CHARS.put(Character.valueOf('*'), "/J");
		EXT_CHARS.put(Character.valueOf('+'), "/K");
		EXT_CHARS.put(Character.valueOf(','), "/L");
		EXT_CHARS.put(Character.valueOf('/'), "/O");
		EXT_CHARS.put(Character.valueOf(':'), "/Z");
		EXT_CHARS.put(Character.valueOf(';'), "%F");
		EXT_CHARS.put(Character.valueOf('«'), "%G");
		EXT_CHARS.put(Character.valueOf('='), "%H");
		EXT_CHARS.put(Character.valueOf('>'), "%I");
		EXT_CHARS.put(Character.valueOf('?'), "%J");
		EXT_CHARS.put(Character.valueOf('@'), "%V");
		EXT_CHARS.put(Character.valueOf('['), "%K");
		EXT_CHARS.put(Character.valueOf('\\'), "%L");
		EXT_CHARS.put(Character.valueOf(']'), "%M");
		EXT_CHARS.put(Character.valueOf('^'), "%N");
		EXT_CHARS.put(Character.valueOf('_'), "%O");
		EXT_CHARS.put(Character.valueOf('`'), "%W");
		EXT_CHARS.put(Character.valueOf('{'), "%P");
		EXT_CHARS.put(Character.valueOf('|'), "%Q");
		EXT_CHARS.put(Character.valueOf('}'), "%R");
		EXT_CHARS.put(Character.valueOf('~'), "%S");

		EXT_CHARS.put(Character.valueOf('a'), "+A");
		EXT_CHARS.put(Character.valueOf('b'), "+B");
		EXT_CHARS.put(Character.valueOf('c'), "+C");
		EXT_CHARS.put(Character.valueOf('d'), "+D");
		EXT_CHARS.put(Character.valueOf('e'), "+E");
		EXT_CHARS.put(Character.valueOf('f'), "+F");
		EXT_CHARS.put(Character.valueOf('g'), "+G");
		EXT_CHARS.put(Character.valueOf('h'), "+H");
		EXT_CHARS.put(Character.valueOf('i'), "+I");
		EXT_CHARS.put(Character.valueOf('j'), "+J");
		EXT_CHARS.put(Character.valueOf('k'), "+K");
		EXT_CHARS.put(Character.valueOf('l'), "+L");
		EXT_CHARS.put(Character.valueOf('m'), "+M");
		EXT_CHARS.put(Character.valueOf('n'), "+N");
		EXT_CHARS.put(Character.valueOf('o'), "+O");
		EXT_CHARS.put(Character.valueOf('p'), "+P");
		EXT_CHARS.put(Character.valueOf('q'), "+Q");
		EXT_CHARS.put(Character.valueOf('r'), "+R");
		EXT_CHARS.put(Character.valueOf('s'), "+S");
		EXT_CHARS.put(Character.valueOf('t'), "+T");
		EXT_CHARS.put(Character.valueOf('u'), "+U");
		EXT_CHARS.put(Character.valueOf('v'), "+V");
		EXT_CHARS.put(Character.valueOf('w'), "+W");
		EXT_CHARS.put(Character.valueOf('x'), "+X");
		EXT_CHARS.put(Character.valueOf('y'), "+Y");
		EXT_CHARS.put(Character.valueOf('z'), "+Z");
	}

	/**
	 * Returns the module that represents the specified character.
	 *
	 * @param key The data character to get the encoding module for
	 * @return The module that encodes the given char
	 */
	public static Module getModule(final String key) {
		Module module = null;
		module = SET.get(key);
		module.setSymbol(key);
		return module;
	}

	/**
	 * Returns the index of the given character in the encoding tables. This is used
	 * when calculating the checksum.
	 *
	 * @param key The data character sequence to get the index for
	 * @return The index for the given key
	 */
	public static int getIndex(final String key) {
		return KEYS.indexOf(key);
	}

	/**
	 * Indicates whether the given key is represented in the default encoding
	 * table that this module factory contains.
	 *
	 * @return True if the key has a direct module encoding, false if not
	 */
	public static boolean hasModule(final String key, final boolean extendedMode) {
		if (extendedMode && ESCAPE_CHARS.contains(key)) {
			return false;
		}
		return getIndex(key) != -1;
	}

	/**
	 * Returns the encoded module at the given index position. This is used to
	 * get the encoded checksum character.
	 *
	 * @param index The index to get the module for
	 * @return The module at the specified index
	 */
	public static Module getModuleForIndex(final int index) {
		return getModule(KEYS.get(index));
	}

	/**
	 * Returns the string of characters from the standard encoding table that encode
	 * the given extended character set character.
	 *
	 * @param c The character from the extended ASCII set to encode
	 * @return The string of characters from the default Code 39 encoding table that represent the given character
	 */
	public static String getExtendedCharacter(final char c) {
		return EXT_CHARS.get(Character.valueOf(c));
	}
}
