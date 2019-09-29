import java.util.ArrayList;
import java.util.List;

public class ABCPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * String [] grid = { "ABE", "CFG", "BDH", "ABC" };
		 */
		
		/* String [] grid = { "A" }; */
		
		
		/* String [] grid = { "BCDEFGHIJKLMNOPQRSTUVWXYZ" }; */
		  
		
		/* String [] grid = { "C", "D", "B", "A" }; */
		  
		
		/*
		 * String [] grid = { "KCBVNRXSPVEGUEUFCODMOAXZYWEEWNYAAXRBKGACSLKYRVRKIO",
		 * "DIMCZDMFLAKUUEPMPGRKXSUUDFYETKYQGQHNFFEXFPXNYEFYEX",
		 * "DMFRPZCBOWGGHYAPRMXKZPYCSLMWVGMINAVRYUHJKBBRONQEXX",
		 * "ORGCBHXWMTIKYNLFHYBVHLZFYRPOLLAMBOPMNODWZUBLSQSDZQ",
		 * "QQXUAIPSCEXZTTINEOFTJDAOBVLXZJLYOQREADUWWSRSSJXDBV",
		 * "PEDHBZOVMFQQDUCOWVXZELSEBAMBRIKBTJSVMLCAABHAQGBWRP",
		 * "FUSMGCSCDLYQNIXTSTPJGZKDIAZGHXIOVGAZHYTMIWAIKPMHTJ",
		 * "QMUEDLXSREWNSMEWWRAUBFANSTOOJGFECBIROYCQTVEYGWPMTU",
		 * "FFATSKGRQJRIQXGAPLTSXELIHXOPUXIDWZHWNYUMXQEOJIAJDH",
		 * "LPUTCFHYQIWIYCVOEYHGQGAYRBTRZINKBOJULGYCULRMEOAOFP",
		 * "YOBMTVIKVJOSGRLKTBHEJPKVYNLJQEWNWARPRMZLDPTAVFIDTE",
		 * "OOBFZFOXIOZFWNIMLKOTFHGKQAXFCRZHPMPKGZIDFNBGMEAXIJ",
		 * "VQQFYCNJDQGJPYBVGESDIAJOBOLFPAOVXKPOVODGPFIYGEWITS",
		 * "AGVBSRLBUYOULWGFOFFYAAONJTLUWRGTYWDIXDXTMDTUYESDPK",
		 * "AAJOYGCBYTMXQSYSPTBWCSVUMNPRGPOEAVVBGMNHBXCVIQQINJ",
		 * "SPEDOAHYIDYUJXGLWGVEBGQSNKCURWYDPNXBZCDKVNRVEMRRXC",
		 * "DVESXKXPJBPSJFSZTGTWGAGCXINUXTICUCWLIBCVYDYUPBUKTS",
		 * "LPOWAPFNDRJLBUZTHYVFHVUIPOMMPUZFYTVUVDQREFKVWBPQFS",
		 * "QEASCLDOHJFTWMUODRKVCOTMUJUNNUYXZEPRHYOPUIKNGXYGBF",
		 * "XQUPBSNYOXBPTLOYUJIHFUICVQNAWFMZAQZLTXKBPIAKXGBHXX" };
		 */
		 
		 
		  
		/* String [] grid = { "EDCCBA", "EDCCBA" }; */ 
		  
		
		  String [] grid = { "AMNOPA", "ALEFQR", "KDABGS", "AJCHUT", "AAIWVA", "AZYXAA"
		  };
		 
		 
		
		System.out.println(length(grid));

	}
	
	public static int length(String[] grid) {
		 
		 int rowSize =  grid.length;		 
		 int colSize =  grid[0].length();
		 
		 char [][] charGrid = new char[rowSize][colSize];
		 
		 int idx = 0;
		 for(String str : grid) {
			 charGrid[idx++] =  str.toCharArray();			
		 }
		 
		 List<IndexModel> aSIndices = findAsIndices(charGrid, rowSize, colSize);
		 
		 return findPath(charGrid, aSIndices, rowSize, colSize);	 		 
		 
	 }
	 
	 
	private static int findPath(char [][] charGrid , List<IndexModel> aSIndices ,int row, int col) {
		
		int max = 0;
		
		for(IndexModel model : aSIndices) {
			
			int count = 1;
			
			int pathLen = findAdjecentNodes(charGrid ,model,count,row,col);
			
			if(pathLen > max) {
				max = pathLen;
			}
			
		}
				
		return max;
	}
	 
	private static int findAdjecentNodes(char [][] charGrid ,IndexModel model, int count, int row, int col) {
		
		int charAscii = (int)charGrid[model.getI()][model.getJ()];
		
		int max = 0;
		
		// top
		if(((model.getI()-1) >= 0 ) && ((int)charGrid[model.getI()-1][model.getJ()] == (charAscii+1)) ) {
			int topcount = findAdjecentNodes(charGrid, new IndexModel(model.getI()-1, model.getJ()), count+1, row, col);			
			max = topcount > max ? topcount : max;
		}
		
		//right
		if((model.getJ()+1) < col && ((int)charGrid[model.getI()][model.getJ()+1] == (charAscii+1))) {
			int rightcount = findAdjecentNodes(charGrid, new IndexModel(model.getI(), model.getJ()+1), count+1, row, col);
			max = rightcount > max ? rightcount : max;
		}
		
		// bottom
		if((model.getI()+1) < row && ((int)charGrid[model.getI()+1][model.getJ()] == (charAscii+1))) {
			int bottomCount = findAdjecentNodes(charGrid, new IndexModel(model.getI()+1, model.getJ()), count+1, row, col);
			max = bottomCount > max ? bottomCount : max;
		}
		
		//left
		if((model.getJ()-1) >= 0 && ((int)charGrid[model.getI()][model.getJ()-1] == (charAscii+1))) {
			int leftCount = findAdjecentNodes(charGrid, new IndexModel(model.getI(), model.getJ()-1), count+1, row, col);
			max = leftCount > max ? leftCount : max;
		}
		
		// left top diagonal
		if((model.getI()-1) >= 0 && (model.getJ()-1) >= 0  && ((int)charGrid[model.getI()-1][model.getJ()-1] == (charAscii+1))) {
			int leftCount = findAdjecentNodes(charGrid, new IndexModel(model.getI()-1, model.getJ()-1), count+1, row, col);
			max = leftCount > max ? leftCount : max;
		}
		
		// left top diagonal
		if((model.getI()-1) >= 0 && (model.getJ()+1) < col  && ((int)charGrid[model.getI()-1][model.getJ()+1] == (charAscii+1))) {
			int leftCount = findAdjecentNodes(charGrid, new IndexModel(model.getI()-1, model.getJ()+1), count+1, row, col);
			max = leftCount > max ? leftCount : max;
		}
		
		// right bottom diagonal
		if((model.getI()+1) < row && (model.getJ()+1) < col  && ((int)charGrid[model.getI()+1][model.getJ()+1] == (charAscii+1))) {
			int leftCount = findAdjecentNodes(charGrid, new IndexModel(model.getI()+1, model.getJ()+1), count+1, row, col);
			max = leftCount > max ? leftCount : max;
		}
		
		// left bottom diagonal
		if((model.getI()+1) < row && (model.getJ()-1) >= 0  && ((int)charGrid[model.getI()+1][model.getJ()-1] == (charAscii+1))) {
			int leftCount = findAdjecentNodes(charGrid, new IndexModel(model.getI()+1, model.getJ()-1), count+1, row, col);
			max = leftCount > max ? leftCount : max;
		}
		
		
		
		return max > count ? max : count;	
		
	}

	static List<IndexModel> findAsIndices(char [][] charGrid , int row, int col) {
		
		List<IndexModel> indexModels = new ArrayList<ABCPath.IndexModel>();
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {				
				if(charGrid[i][j] == 'A') {
					indexModels.add(new IndexModel(i, j));
				}
			}
		}
		
		return indexModels;
		
	}
	
	static class IndexModel{
		int i,j;

		public IndexModel(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}

		public int getJ() {
			return j;
		}

		public void setJ(int j) {
			this.j = j;
		}		
		
	}

}
