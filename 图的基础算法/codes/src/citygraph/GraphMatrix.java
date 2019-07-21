package citygraph;

public class GraphMatrix {
	static final int MaxNum = 20;
	static final int MaxValue = 65535;
	char [] Vertices = new char[MaxNum]; // ���涥����Ϣ, ��Ż�������
	int GType; // ͼ����Ϣ(0: ����ͼ, 1: ����ͼ)
	int VertexNum; // ���������
	int EdgeNum; // �ߵ�����
	int [][] EdgeWeight = new int[MaxNum][MaxNum]; // ����ߵ�Ȩ��
	int [] isTrav = new int [MaxNum];
	
	public void showInfo () {
		System.out.println("ͼ��������:" + (this.GType == 0 ? "����ͼ" : "����ͼ"));
		System.out.println("ͼ����" + this.VertexNum + "������");
		System.out.println("ͼ����" + this.EdgeNum + "����");
	}
	
	
	public static void main (String [] args) {
		GraphMatrix GM = new GraphMatrix();
		GM.showInfo();
		GM.EdgeNum = 10;
		GM.showInfo();
	}
}
