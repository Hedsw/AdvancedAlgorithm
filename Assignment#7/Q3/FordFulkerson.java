import java.util.*;

public class FordFulkerson {
	static final int vC = 26; 	
	
	private String[] Nodes;	

	public FordFulkerson(String[] Nodes){
		this.Nodes=Nodes;	
	}

	public boolean binarySearchTree(int rGraph[][], int vS, int vT, int p[]) {
		boolean assigned[] = new boolean[vC];

		LinkedList<Integer> vQueue = new LinkedList<Integer>();	
		vQueue.add(vS);	
		assigned[vS] = true;	
		p[vS]=-1;			

		while (!vQueue.isEmpty()) {
			int vU = vQueue.remove();		
			for (int vV=0; vV<vC; vV++) {	
				if (assigned[vV]==false && rGraph[vU][vV] > 0) {	
					vQueue.add(vV);
					p[vV] = vU;		
					assigned[vV] = true;
				}
			}
		}
		return assigned[vT];	
	}

	public int mFlow(int graph[][], int vS, int vT) {
		int mFlow = 0;
		int p[] = new int[vC];	
		int vU=0;	
		int vV =0;

		int rGraph[][] = new int[vC][vC];	
		for (vU = 0; vU < vC; vU++){		
			for (vV = 0; vV < vC; vV++){
				rGraph[vU][vV] = graph[vU][vV];
			}
		}

		while (binarySearchTree(rGraph, vS, vT, p)) {		
			String pString = "";		

			int btFlow = Integer.MAX_VALUE;		
			for (vV=vT; vV != vS; vV=p[vV]) {		
				vU = p[vV];		
				btFlow = Math.min(btFlow, rGraph[vU][vV]);		

				pString = " --> "+Nodes[vV]+ pString;
			}
			pString= "S"+pString;		
			System.out.println("Augment Path is.. \n"+pString);
			System.out.println("Bottleneck is.. Minimum flow on path added to Maximum flow = "+btFlow +"\n");

			for (vV=vT; vV != vS; vV=p[vV]) {	
				vU = p[vV];
				rGraph[vU][vV] -= btFlow;		
				rGraph[vV][vU] += btFlow;		
			}

			mFlow += btFlow;		
		}

		return mFlow;
	}

	public static void main (String[] args) {
	
		String[] Nodes = { "S",  
		"n1", "n2", "n3", "n4", "n5", "n6", "n7", "n8", "n9", "n10", "n11", "n12","n13", "n14", "n15",
		"k1", "k2", "k3", "k4", "m1", "m2", "m3", "m4", "m5", "T" };	
		int gMatrix[][] =new int[][] {
		
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
		
		FordFulkerson mFlowFinder = new FordFulkerson(Nodes);

		int vS = 0;
		int vT = vC-1;
		System.out.println("\n Ford Fulkerson Max Flow: " + mFlowFinder.mFlow(gMatrix, vS, vT));
	}
}