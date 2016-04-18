package in.vshukla.arithmetic;

import in.vshukla.arithmetic.exception.InvalidOperatorException;
import in.vshukla.arithmetic.exception.InvalidParameterException;
import in.vshukla.arithmetic.exception.InvalidValueException;

public class Main {
	public static void main(String[] args) {
		Arguments arguments;
		try {
			arguments = parseCmdArgs(args);
		} catch (InvalidParameterException e) {
			System.out.println(e.getMessage());
			System.out.println(getUsageString());
			return;
		} catch (InvalidOperatorException e) {
			System.out.println(e.getMessage());
			System.out.println(getUsageString());
			return;
		} catch (InvalidValueException e) {
			System.out.println(e.getMessage());
			System.out.println(getUsageString());
			return;
		}
		Session session = new Session(arguments);
	}

	private static String getUsageString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Usage : \n");
		sb.append("arithmetic -r range -n num_questions -o operator\n");
		sb.append("Use -o multiple times to select multiple operator.\n");
		sb.append("Supported operators : +-/*\n");
		sb.append("Default range : 10\n");
		sb.append("Default num_questions : 20\n");
		sb.append("Default operators : +-\n");
		return sb.toString();
	}

	private static Arguments parseCmdArgs(String[] args) throws InvalidParameterException, InvalidOperatorException, InvalidValueException {
		Arguments arguments = new Arguments();
		for (int i = 0; i < args.length; i++) {
			String a = args[i];
			switch (a) {
				case "-n":
					i++;
					arguments.setNumQuestions(args[i]);
					break;
				case "-r":
					i++;
					arguments.setRange(args[i]);
					break;
				case "-o":
					i++;
					arguments.addOperator(args[i]);
					break;
				default:
					if (a.startsWith("-")) {
						throw new InvalidParameterException("Unknown option " + a);
					} else {
						throw new InvalidParameterException("Unknown parameter " + a);
					}
			}
		}
		return arguments;
	}
}
