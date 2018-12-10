
/**
 * ���������, ���� ������ ����� ��� ���������� ��'���� �� ����� ����������
 * 
 * @author ������� �����, 4 �����, ���
 *
 * @param <Key>
 */
public interface Comparator<Key> {

	/**
	 * ��������� ���� ��'����
	 * 
	 * @param v
	 * @param w
	 * @return
	 */
	public int compare(Key v, Key w);
}
