package citygraph;

import java.util.Scanner;

public class CityGraph {
	static Scanner inputScanner = new Scanner(System.in);
	
	// 创建图
	private static void CreateGraph (GraphMatrix GM) {
		int weight;
		char EStartV, EEndV; // 边的起始信息
		System.out.println("输入图中各顶点的信息");
		
		// 输入定点
		for (int i = 0; i < GM.VertexNum; i++) {
			System.out.println("第" + (i+1) + "个顶点");
			GM.Vertices[i] = (inputScanner.next().toCharArray())[0];
		}
		System.out.println("输入构成各边的顶点及权重值");
		for (int i = 0; i < GM.VertexNum; i++) {
			System.out.println("第" + (i + 1) + "条边");
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
	
	// 清空图
	private static void ClearGraph (GraphMatrix GM) {
		for (int i = 0; i < GM.VertexNum; i++) {
			for (int j = 0; j < GM.VertexNum; j++) {
				GM.EdgeWeight[i][j] = GraphMatrix.MaxValue;
			}
		}
	}
	
	// 遍历输出图
	private static void OutGraph (GraphMatrix GM) {
		for (int i = 0; i < GM.VertexNum; i++) {
			System.out.printf("\t%c", GM.Vertices[i]); // 第一行输出顶点的信息
		}
		System.out.println();
		for (int i = 0; i < GM.VertexNum; i++) {
			System.out.printf("%c", GM.Vertices[i]);
			for (int j = 0; j < GM.VertexNum; j++) {
				if (GM.EdgeWeight[i][j] == GraphMatrix.MaxValue) {
					System.out.printf("\t∞");
				} else {
					System.out.printf("\t%d", GM.EdgeWeight[i][j]);
				}
			}
			System.out.println();
		}
	}
	
	// DFS 深度优先搜索
	private static void DFSOne(GraphMatrix GM, int n) { // 从第n个节点开始, 深度遍历图
		GM.isTrav[n] = 1;
		System.out.println("->" + GM.Vertices[n]); // 输出节点数据
		// 添加节点操作
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
		System.out.println("这是城市路径的程序");
		GraphMatrix GM = new GraphMatrix(); // 定义保存邻接表结构的图
		System.out.println("输入生成图的类型:(0: 无向图, 1: 有向图)");
		GM.GType = inputScanner.nextInt();
		System.out.println("输入图的顶点数量:");
		GM.VertexNum = inputScanner.nextInt();
		System.out.println("请输入图的边数量:");
		GM.EdgeNum = inputScanner.nextInt();
		// 展示图的信息
		GM.showInfo();
		ClearGraph(GM); // 清空图
		CreateGraph(GM); // 生成图
		System.out.println("该图的邻接矩阵如下表示:");
		OutGraph(GM); // 输出邻接矩阵
		DFS(GM);
	}
}


//class GraphMatrix {
//	static final int MaxNum = 20;
//	static final int MaxValue = 65535;
//	char [] Vertices = new char[MaxNum]; // 保存顶点信息, 序号或者数字
//	int GType; // 图的信息(0: 无向图, 1: 有向图)
//	int VertexNum; // 定点的数量
//	int EdgeNum; // 边的数量
//	int [][] EdgeWeight = new int[MaxNum][MaxNum]; // 保存边的权重
//	int [] isTrav = new int [MaxNum];
//}