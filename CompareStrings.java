public class CompareStrings
{
	public static int compare(String first, String second)
	{
		boolean isInt1 = false, isInt2 = false;
		int val1 = 0, val2 = 0;
		if(first.matches("[0-9]+")) 
		{
			val1 += Integer.valueOf(first);
			isInt1 = true;
		}

		if(second.matches("[0-9]+")) 
		{
			val2 += Integer.valueOf(second);
			isInt2 = true;
		}

		if(!isInt1)
		{
			val1 += 10000;
			for(int i = 0; i < first.length(); i++) val1 += charValue(first.charAt(i));
		}

		if(!isInt2)
		{
			val2 += 10000;
			for(int i = 0; i < second.length(); i++) val2 += charValue(second.charAt(i));
		}
		return val1 - val2;
	}

	private static int charValue(char a)
	{
		if(a == '0') return 2;
		else if(a == '1') return 3;
		else if(a == '2') return 4;
		else if(a == '3') return 5;
		else if(a == '4') return 6;
		else if(a == '5') return 7;
		else if(a == '6') return 8;
		else if(a == '7') return 9;
		else if(a == '8') return 10;
		else if(a == '9') return 11;
		else if(a == 'A') return 12;
		else if(a == 'a') return 13;
		else if(a == 'B') return 14;
		else if(a == 'b') return 15;
		else if(a == 'C') return 16;
		else if(a == 'c') return 17;
		else if(a == 'D') return 18;
		else if(a == 'd') return 19;
		else if(a == 'E') return 20;
		else if(a == 'e') return 21;
		else if(a == 'F') return 22;
		else if(a == 'f') return 23;
		else if(a == 'G') return 24;
		else if(a == 'g') return 25;
		else if(a == 'H') return 26;
		else if(a == 'h') return 27;
		else if(a == 'I') return 28;
		else if(a == 'i') return 29;
		else if(a == 'J') return 30;
		else if(a == 'j') return 31;
		else if(a == 'K') return 32;
		else if(a == 'k') return 33;
		else if(a == 'L') return 34;
		else if(a == 'l') return 35;
		else if(a == 'M') return 36;
		else if(a == 'm') return 37;
		else if(a == 'N') return 38;
		else if(a == 'n') return 39;
		else if(a == 'O') return 40;
		else if(a == 'o') return 41;
		else if(a == 'P') return 42;
		else if(a == 'p') return 43;
		else if(a == 'Q') return 44;
		else if(a == 'q') return 45;
		else if(a == 'R') return 46;
		else if(a == 'r') return 47;
		else if(a == 'S') return 48;
		else if(a == 's') return 49;
		else if(a == 'T') return 50;
		else if(a == 't') return 51;
		else if(a == 'U') return 52;
		else if(a == 'u') return 53;
		else if(a == 'V') return 54;
		else if(a == 'v') return 55;
		else if(a == 'W') return 56;
		else if(a == 'w') return 57;
		else if(a == 'X') return 58;
		else if(a == 'x') return 59;
		else if(a == 'Y') return 60;
		else if(a == 'y') return 61;
		else if(a == 'Z') return 62;
		else if(a == 'z') return 63;
		return 1;
	}
}
