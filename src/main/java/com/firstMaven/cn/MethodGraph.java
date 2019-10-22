package com.firstMaven.cn;

import java.util.*;

import org.apache.commons.lang3.StringUtils;
public class MethodGraph {

	
	private List<MethodVertex> methodVertexList;
    private ClassGraph belongClassGraph;
    
    
	
	public ClassGraph getBelongClassGraph() {
		return belongClassGraph;
	}
	public void setBelongClassGraph(ClassGraph belongClassGraph) {
		this.belongClassGraph = belongClassGraph;
	}
	public List<MethodVertex> getMethodVertexList() {
		return methodVertexList;
	}
	public void setMethodVertexList(List<MethodVertex> methodVertexList) {
		this.methodVertexList = methodVertexList;
	}


	

	public List<MethodGraph> gen_MCG(List<ClassGraph> classGraphList,AllMethodDependence allMethodDependence){//˼·���Ǵ���С�飬ֱ���ֵ�MCG
	    List<MethodGraph> methodGraphList=new ArrayList();
		List<MethodVertex> allMethodVertexList=allMethodDependence.getMethodVertexList();
		Stack<MethodVertex> stack=new Stack<MethodVertex>();
		Queue<MethodVertex> queue=new LinkedList();
		int x=0;
		int xy=0;
		for(int i=0;i<allMethodVertexList.size();i++) {
			int y=0;
			//System.out.println(x);
			//System.out.println(allMethodVertexList.get(i).getBelongClass());
			MethodVertex firstMethodVertex=allMethodVertexList.get(i);
			if(firstMethodVertex.isVisited()==true)
				continue;
			ClassGraph belongClassGraph=findClassGraph(classGraphList,firstMethodVertex);
			if(belongClassGraph==null) {//�Ҳ���CDG˵���˷���Ϊ���࣬
				
				//if(firstMethodVertex.getMethodEdgeList()!=null&&firstMethodVertex.getMethodEdgeList().size()>0)
					//System.out.println(firstMethodVertex.getBelongClass());
			    firstMethodVertex.setVisited(true);
			    x++;
			    continue;
			    
			}
			//System.out.println(allMethodVertexList.get(i).getBelongClass());
			MethodGraph methodGraph=new MethodGraph();
		
			List<MethodVertex> methodVertexList=new ArrayList();

			queue.offer(firstMethodVertex);
			while(!queue.isEmpty()) {
				MethodVertex topVertex=queue.poll();
				
				if(topVertex.isVisited()==true)
					continue;
				if(topVertex.getMethodEdgeList()==null) {
					topVertex.setVisited(true);
					//System.out.println(topVertex.getBelongClass());
					//System.out.println(topVertex.getMethodName());
					methodVertexList.add(topVertex);
					y++;
					x++;
					continue;
				}
				
				for(int j=0;j<topVertex.getMethodEdgeList().size();j++) {
					xy++;
					MethodEdge methodEdge=topVertex.getMethodEdgeList().get(j);
					MethodVertex findVertex=checkEdge(methodEdge,allMethodVertexList);
					if(findVertex==null)
						continue;
					queue.offer(findVertex);
					
					
				}
				topVertex.setVisited(true);
				methodVertexList.add(topVertex);
				x++;
				y++;
			}
			//if(y==0) {
				//System.out.println(firstMethodVertex.getBelongClass()+"0");
				//System.out.println(firstMethodVertex.getMethodName()+"0");
				
			//}
			//System.out.println("һ��mcg�ķ�����Ŀ"+y);
			
			methodGraph.setMethodVertexList(methodVertexList);
			methodGraphList.add(methodGraph);
		
		}
		//System.out.println("��ӵķ�����"+x);
		//System.out.println("��ӵı���"+xy);
		return methodGraphList;
		 
	}
	
	
	public MethodVertex checkEdge(MethodEdge methodEdge,List<MethodVertex> methodVertexList) {
		String mn=methodEdge.getNextMethodName();
		String cn=methodEdge.getNextClassName();
		String[] a=StringUtils.split(cn,"/");
		String d="Ljava";
	    String g="Ljavax";
	    String e="Landroid";
	    String h="Lorg";
		if(a[0].equals(d)||a[0].equals(g)||a[0].equals(e)||a[0].equals(h))
			return null;
		else {
			for(int i=0;i<methodVertexList.size();i++) {
				MethodVertex methodVertex=methodVertexList.get(i);
				if(methodVertex.getMethodName().equals(mn)
				   &&methodVertex.getBelongClass().equals(cn))
					return methodVertex;
			}
			//System.out.println("xuwu");
			return null;
			
		}
	}
	
	
	public ClassGraph findClassGraph(List<ClassGraph> classGraphList1,MethodVertex methodVertex) {
		for(int i=0;i<classGraphList1.size();i++) {
			List<ClassVertex> classVertexList=classGraphList1.get(i).getClassVertexList();
			boolean flag=findGraph(classVertexList,methodVertex);
			if(flag==true)
				return classGraphList1.get(i);
		}
		return null;
	}
	public boolean findGraph(List<ClassVertex> classVertexList,MethodVertex methodVertex) {
		for(int j=0;j<classVertexList.size();j++) {
			if(classVertexList.get(j).getClassName().equals(methodVertex.getBelongClass()))
				return true;
		}
		return false;
	}
}
