
/**
 * ����, � ����� �������� ����������� ������ ���������� ��'����, � �����
 * ���������� �� ������ ��������
 * 
 * @author ������� �����, 4 �����, ���
 *
 */
public class Film implements Comparable<Film> {

	private final String name; // �����
	private final int year; // �� �������
	private final int length; // ��������� (� ��)
	public static final Comparator<Film> BY_NAME = new ByName(); // ���������� �� ������
	public static final Comparator<Film> BY_LENGTH = new ByLength(); // ���������� �� ��������� ������ (� ��)

	/**
	 * �����������
	 * 
	 * @param name   �����
	 * @param year   �� �������
	 * @param length ���������
	 */
	public Film(String name, int year, int length) {
		this.name = name;
		this.year = year;
		this.length = length;
	}

	@Override
	public int compareTo(Film that) {
		if (this.year < that.year)
			return -1;
		if (this.year > that.year)
			return 1;
		return 0;
	}

	@Override
	public String toString() {
		return "Film: name = " + name + ", year = " + year + ", length = " + length;
	}

	/**
	 * ����, ���� ������� ���������� ������ �� ��������
	 *
	 */
	private static class ByLength implements Comparator<Film> {

		@Override
		public int compare(Film v, Film w) {
			if (v.length < w.length)
				return -1;
			if (v.length > w.length)
				return 1;
			return 0;
		}
	}

	/**
	 * ����, ���� ������� ���������� ������ �� ������
	 *
	 */
	private static class ByName implements Comparator<Film> {
		
		@Override
		public int compare(Film v, Film w) {
			return v.name.compareTo(w.name);
		}
	}

}
