package rtti;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @project MyBlog
 * @create 2013��6��28�� ����3:00:33
 * @version 1.0.0
 * @author �Ź�
 */
public class ToyReflection {
	public static void printInfo(String info, Object obj) {
		if (obj.getClass().isArray()) {
			System.out.println(info + ": ");
			int length = Array.getLength(obj);
			System.out.println("Array Size: " + length);
			for (int i = 0; i < length; i++) {
				System.out.print("Array[" + i + "]: " + Array.get(obj, i) + ", ");
			}
			if (length != 0)
				System.out.println();
		}
		System.out.println(info + ": " + obj.toString());
	}

	public static void main(String[] args) {

		try {
			// ��������
			Class<?> c = Class.forName("rtti.Toy");
			printInfo("��������", c);

			// ��ó���
			Class<?> superClass = c.getSuperclass();
			printInfo("��ó���", superClass);

			// ������и��ӿ�
			Class<?>[] interfaces = c.getInterfaces();
			printInfo("������и��ӿ�", interfaces);

			// ʵ����
			Toy toy = (Toy) c.newInstance();
			printInfo("ʵ����", toy);

			// ��÷�������Ϊpublic�Ĺ��췽��
			Constructor<?>[] constructors = c.getConstructors();
			printInfo("��ù��췽��", constructors);

			// ���ָ�������Ĺ��췽��
			Constructor<?> constructor = c.getDeclaredConstructor(String.class, String.class, int.class);
			printInfo("���ָ�����췽��", constructor);

			// ��÷�����getMethodֻ�ܻ��public��������������ͽӿڼ̳еķ���
			Method method = c.getMethod("playToy", String.class);
			printInfo("��ù��з���", method);

			// ���÷���
			method.invoke(toy, "����");

			// ������η�������private/public/protect,static
			String modifier = Modifier.toString(method.getModifiers());
			printInfo("������η�", modifier);

			// ��ò�������
			Class<?>[] paramTypes = method.getParameterTypes();
			printInfo("��ò�������", paramTypes);

			// ��÷���ֵ����
			Class<?> returnType = method.getReturnType();
			printInfo("��÷���ֵ����", returnType);

			// ����쳣����
			Class<?>[] excepTypes = method.getExceptionTypes();
			printInfo("����쳣����", excepTypes);

			// ����˽�з�����getDeclaredMethod���������ķ���������public,protect,private����
			Method method2 = c.getDeclaredMethod("buildMsg", String.class);
			method2.setAccessible(true);
			String result = (String) method2.invoke(toy, "����");
			printInfo("���˽�з���", result);

			// ���ȫ������
			Field[] fields = c.getFields();
			printInfo("���ȫ������", fields);

			// ������������ָ������
			Field field = c.getDeclaredField("name");
			printInfo("�����������", field);

			// ����༰�丸�࣬���ӿڶ����public����
			Field field2 = c.getField("color");
			printInfo("��ù�������", field2);

			// ���Ȩ�����η�������private/public/protect,static,final
			String fieldModifier = Modifier.toString(field.getModifiers());
			printInfo("���Ȩ�����η�", fieldModifier);

			// ��������
			int[] exampleArray = { 1, 2, 3, 4, 5 };
			// �����������
			Class<?> componentType = exampleArray.getClass().getComponentType();
			printInfo("��������", componentType.getName());
			// ��ó���
			printInfo("���鳤��", Array.getLength(exampleArray));
			// ���ָ��Ԫ��
			printInfo("�������Ԫ��", Array.get(exampleArray, 2));
			// �޸�ָ��Ԫ��
			Array.set(exampleArray, 2, 6);
			printInfo("�޸�����Ԫ��", exampleArray);

			// ��õ�ǰ���������
			printInfo("��õ�ǰ�������", toy.getClass().getClassLoader().getClass().getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}

	}
}
