import java.util.*;

public class FordFulkerson {
	static final int vC = 30; 	
	
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
	
		String[] Nodes = {"S", "P1", "P2", "P3", "P4", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "D11", "D12", "H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "H11", "H2", "T"};	
		int gMatrix[][] =new int[][] {
		
			{0,3,3,3,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, // S -> P 
			
			{0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,0,1,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,1,1,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,1,1,0},

			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
		};
		
		
		FordFulkerson mFlowFinder = new FordFulkerson(Nodes);

		int vS = 0;
		int vT = vC-1;
		System.out.println("\n Ford Fulkerson Max Flow: " + mFlowFinder.mFlow(gMatrix, vS, vT));
	}
}