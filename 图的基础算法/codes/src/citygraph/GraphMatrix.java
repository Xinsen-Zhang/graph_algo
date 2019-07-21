package citygraph;

public class GraphMatrix {
	static final int MaxNum = 20;
	static final int MaxValue = 65535;
	char [] Vertices = new char[MaxNum]; // 保存顶点信息, 序号或者数字
	int GType; // 图的信息(0: 无向图, 1: 有向图)
	int VertexNum; // 定点的数量
	int EdgeNum; // 边的数量
	int [][] EdgeWeight = new int[MaxNum][MaxNum]; // 保存边的权重
	int [] isTrav = new int [MaxNum];
	
	public void showInfo () {
		System.out.println("图的类型是:" + (this.GType == 0 ? "无向图" : "有向图"));
		System.out.println("图共有" + this.VertexNum + "个定点");
		System.out.println("图共有" + this.EdgeNum + "条边");
	}
	
	
	public static void main (String [] args) {
		GraphMatrix GM = new GraphMatrix();
		GM.showInfo();
		GM.EdgeNum = 10;
		GM.showInfo();
	}
}
