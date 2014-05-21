/**
 * 字符串反转
 * 
 * @author renwei
 * 
 */
public class ReserverString
{
	private static final char ZERO = '0';
	private static final char ONE = '1';
	private static final char SPACE = ' ';

	/**
	 * 反转字符串
	 * 
	 * @param input
	 *            输入字符串
	 * @return 反转后的字符串
	 */
	private static String reserverString(String input)
	{
		final StringBuilder strBuilder = new StringBuilder();
		final String template = constructTemplate(input);
		extractStr(input, strBuilder);
		return adapterTemplate(strBuilder, template);
	}

	/**
	 * 构造模板
	 * 
	 * @param input
	 *            输入字串
	 * @return 反转后模板
	 */
	private static String constructTemplate(String input)
	{
		final StringBuilder base = new StringBuilder();
		for (int index = 0; index < input.length(); index++)
		{
			if (input.charAt(index) == SPACE)
			{
				base.append(ZERO);
			}
			else
			{
				base.append(ONE);
			}
		}
		return base.reverse().toString();
	}

	/**
	 * 提取单个字串
	 * 
	 * @param value
	 *            输入字串
	 * @param result
	 *            收集实际字串
	 */
	private static void extractStr(String value, StringBuilder result)
	{
		String trimStr = value.trim();
		final int index = trimStr.indexOf(" ");
		if (index == -1)
		{
			result.append(trimStr);
		}
		else
		{
			final String baseStr = trimStr.substring(0, index);
			final String rest = trimStr.substring(index, trimStr.length());
			extractStr(rest, result);
			result.append(baseStr);
		}
	}

	/**
	 * 适配模板与字符串
	 * 
	 * @param value
	 * @param template
	 * @return
	 */
	private static String adapterTemplate(StringBuilder value, String template)
	{
		final StringBuilder result = new StringBuilder();
		int base = 0;
		for (int index = 0; index < template.length(); index++)
		{
			if (template.charAt(index) == ZERO)
			{
				result.append(" ");
			}
			else if (template.charAt(index) == ONE)
			{
				result.append(value.toString().charAt(base++));
			}
		}
		return result.toString();
	}

	/**
	 * 测试
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		String input = " today is a good day! ";
		System.out.println("input==" + input);
		final String result = reserverString(input);
		System.out.println("result==" + result);
	}
}
