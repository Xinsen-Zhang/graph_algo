package citygraph;

import java.util.Scanner;

public class CityGraph {
	static Scanner inputScanner = new Scanner(System.in);
	
	// ����ͼ
	private static void CreateGraph (GraphMatrix GM) {
		int weight;
		char EStartV, EEndV; // �ߵ���ʼ��Ϣ
		System.out.println("����ͼ�и��������Ϣ");
		
		// ���붨��
		for (int i = 0; i < GM.VertexNum; i++) {
			System.out.println("��" + (i+1) + "������");
			GM.Vertices[i] = (inputScanner.next().toCharArray())[0];
		}
		System.out.println("���빹�ɸ��ߵĶ��㼰Ȩ��ֵ");
		for (int i = 0; i < GM.VertexNum; i++) {
			System.out.println("��" + (i + 1) + "����");
			EStartV = inputScanner.next().charAt(0);
			EEndV = inputScanner.next().charAt(0);
			weight = inputScanner.nextInt();
			int StartIndex, EndIndex;
			for(StartIndex=0; EStartV != GM.Vertices[StartIndex]; StartIndex++) {}
			for(EndIndex=0; EEndV != GM.Vertices[EndIndex]; EndIndex++) {}
			GM.EdgeWeight[StartIndex][EndIndex] = weight;
			if (GM.GType == 0) {
				GM.EdgeWeight[EndIndex][StartIndex] = weight;
			}
		}
	}
	
	// ���ͼ
	private static void ClearGraph (GraphMatrix GM) {
		for (int i = 0; i < GM.VertexNum; i++) {
			for (int j = 0; j < GM.VertexNum; j++) {
				GM.EdgeWeight[i][j] = GraphMatrix.MaxValue;
			}
		}
	}
	
	// �������ͼ
	private static void OutGraph (GraphMatrix GM) {
		for (int i = 0; i < GM.VertexNum; i++) {
			System.out.printf("\t%c", GM.Vertices[i]); // ��һ������������Ϣ
		}
		System.out.println();
		for (int i = 0; i < GM.VertexNum; i++) {
			System.out.printf("%c", GM.Vertices[i]);
			for (int j = 0; j < GM.VertexNum; j++) {
				if (GM.EdgeWeight[i][j] == GraphMatrix.MaxValue) {
					System.out.printf("\t��");
				} else {
					System.out.printf("\t%d", GM.EdgeWeight[i][j]);
				}
			}
			System.out.println();
		}
	}
	
	// DFS �����������
	private static void DFSOne(GraphMatrix GM, int n) { // �ӵ�n���ڵ㿪ʼ, ��ȱ���ͼ
		GM.isTrav[n] = 1;
		System.out.println("->" + GM.Vertices[n]); // ����ڵ�����
		// ��ӽڵ����
		for (int i = 0; i < GM.VertexNum; i++) {
			if (GM.EdgeWeight[n][i] != GraphMatrix.MaxValue && GM.isTrav[n] == 0) {
				DFSOne(GM, i);
			}
		}
	}
	private static void DFS(GraphMatrix GM) {
		for (int i = 0; i < GM.VertexNum; i++) {
			GM.isTrav[i] = 0;
		}
		for (int i = 0; i < GM.VertexNum; i++) {
			if (GM.isTrav[i] == 0) {
				DFSOne(GM, i);
			}
		}
	}
	
	public static void main (String [] args) {
		System.out.println("���ǳ���·���ĳ���");
		GraphMatrix GM = new GraphMatrix(); // ���屣���ڽӱ�ṹ��ͼ
		System.out.println("��������ͼ������:(0: ����ͼ, 1: ����ͼ)");
		GM.GType = inputScanner.nextInt();
		System.out.println("����ͼ�Ķ�������:");
		GM.VertexNum = inputScanner.nextInt();
		System.out.println("������ͼ�ı�����:");
		GM.EdgeNum = inputScanner.nextInt();
		// չʾͼ����Ϣ
		GM.showInfo();
		ClearGraph(GM); // ���ͼ
		CreateGraph(GM); // ����ͼ
		System.out.println("��ͼ���ڽӾ������±�ʾ:");
		OutGraph(GM); // ����ڽӾ���
		DFS(GM);
	}
}


//class GraphMatrix {
//	static final int MaxNum = 20;
//	static final int MaxValue = 65535;
//	char [] Vertices = new char[MaxNum]; // ���涥����Ϣ, ��Ż�������
//	int GType; // ͼ����Ϣ(0: ����ͼ, 1: ����ͼ)
//	int VertexNum; // ���������
//	int EdgeNum; // �ߵ�����
//	int [][] EdgeWeight = new int[MaxNum][MaxNum]; // ����ߵ�Ȩ��
//	int [] isTrav = new int [MaxNum];
//}