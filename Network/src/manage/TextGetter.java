package manage;

/**
 * 用来从HTML文档中提取不含任何HTML标签的字符
 * 
 * @author 张广 
 * 
 */
public class TextGetter {
	public static String getText(String htmlText) {
		String text = "";
		int i = 0;
		int len = htmlText.length();
		boolean isHtml = false;
		boolean isBlank = false;// 上一个是不是空格，用于控制出现过多空格
		while (i < len) {
			char c = htmlText.charAt(i);
			i++;
			if (c == '<') {
				isHtml = true;
				continue;
			} else if (c == '>') {
				isHtml = false;
				if (!isBlank) {
					text += " ";
					isBlank = true;
				}
				continue;
			}
			if (!isHtml) {
				text += c;
				isBlank = false;
			}
		}

		return text;
	}

	// public static void main(String[] args){
	// String test = "<h1>计算机科学系网络工程专业本科培养方案</h1>" +
	// "<p style=\"font-family: '楷体_GB2312'; font-size: 14px; text-align:center;
	// color: #F60;\">（2009级）</p>" +
	// "<h2>一、培养目标</h2>" +
	// "<p>培养德、智、体、美、劳全面发展，系统掌握本专业的基本理论、基础知识和基本技能与方法，能够胜任工程开发和科学研究工作的具有良好综合素质和开拓创新能力的高级网络人才。</p>"
	// +
	// "<h2>二、学制与学位授予</h2>" +
	// "<p>本科学制四年。对完成并符合本科培养方案要求的学生授予工学学士学位。 </p>" +
	// "<h2>三、基本学分学时</h2>" +
	// "<p>本科培养总学分不少于160。公共必修（含数学分析）46学分、专业必修（含毕业论文）63学分、" +
	// "选修（含人文选修课）57学分。其中，春、秋季学期课程总学分不少于140，夏季学期实践环节（含军事教育）" +
	// "不少于12学分，毕业论文/设计8学分。</p>" +
	// "<h2>四、课程结构与学分要求</h2>" +
	// "<ol>" +
	// "<li>人文社会科学类课程：51学分，必修35学分，选修16学分</li>" +
	// "</ol>" +
	// "<ul>";
	// System.out.println(test);
	// System.out.print(TextGetter.getText(test));
	//		 }
}
