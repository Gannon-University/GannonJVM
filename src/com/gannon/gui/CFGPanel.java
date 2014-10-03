package com.gannon.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import com.gannon.bytecode.controlflowgraph.CBlock;
import com.gannon.bytecode.controlflowgraph.CEdge;
import com.gannon.bytecode.controlflowgraph.CEdgeValue;
import com.gannon.bytecode.controlflowgraph.CGraph;
import com.gannon.bytecode.controlflowgraph.CNode;
import com.gannon.bytecode.controlflowgraph.CPath;
import com.gannon.program.cfg.EdgeData;
import com.gannon.program.cfg.ForceDirectedLayout;
import com.gannon.program.cfg.GraphPanel;
import com.gannon.program.cfg.Node;
import com.gannon.program.cfg.NodeData;
import com.gannon.program.cfg.Point;
import com.gannon.program.cfg.Spring;



public class CFGPanel extends GraphPanel {

    /**
	 * Control Flow Graph Panel
	 */
	private static final long serialVersionUID = 1L; 
	private final ArrayList<Node> listOfNodes;
    private CGraph cGraph;    // contains list of cfg node
    CNode rootNode;  // root node of the cfg tree

    public Node findNode(int nodeID, String methodName) {
        for (int i = 0; i < listOfNodes.size(); i++) {
            Node node = listOfNodes.get(i);
            if (node.getData().getLabel().equals( String.valueOf(nodeID)) && node.getData().getmName().equals(methodName)) {
                return node;
            }
        }
        return null;
    }

    

    public void drawCFGTree() {
        // getting list of nodes and adding them to the graph
    	LinkedHashSet<CNode> listOfCNodes =cGraph.getCNodes();
        for (Iterator<CNode> iterator = listOfCNodes.iterator(); iterator.hasNext(); ) {
        	CNode nodeToInsert =  iterator.next();
        	//adding tnode to graph panel
            Node newNode = addNode( String.valueOf( nodeToInsert.getId()), nodeToInsert.getMethodName(), nodeToInsert.getClassName(), Color.BLACK, nodeToInsert.getColor(), Color.BLUE, 20.0f);
            // adding new node to listOfNodes
            listOfNodes.add(newNode);
        }

        // adding edges between nodes
        for (Iterator<CNode> iterator = listOfCNodes.iterator(); iterator.hasNext(); ) {
        	CNode parentNode =  iterator.next();
            // getting node from listOfNodes
            Node node = findNode(parentNode.getId(), parentNode.getMethodName());

            // getting list of child node for tnode
            List<CNode> listOfChildNodes =  cGraph.getAdjacentNodes(parentNode);// .getAdjacentNodes(tnode);
            
            // processing child nodes
            for (int j = 0; j < listOfChildNodes.size(); j++) {
            	CNode childNode = listOfChildNodes.get(j);
            	
            	// getting edge value
            	CEdgeValue value = cGraph.getCEdgeValue(parentNode, childNode);
            	
            	// getting node from listOfNodes
                Node graphNode = findNode(childNode.getId(), childNode.getMethodName());
                
                CPath longestPath =  cGraph.getLongestPath(parentNode,childNode);
                
                int  lengthOfLongestPath = longestPath.getNodes().size();// cGraph.getLongestPath(childNode, cnode)"path between " + tnode.getName() + " and " + tnode.getLeft().getName() + " is : " + numberOfPaths);
                
                int numberOfPaths  = cGraph.getNumberOfPathsBetweenTwoNodes(parentNode, childNode);
                //System.out.println("Longest path between " + tnode.getName() + " and " + tnode.getLeft().getName() + " is : " + longestPath);
                
               
                if(cGraph.isLoopEdge(parentNode, childNode)){
                    // Finding max path for loop edge
                  //  int longestPathForLoop = cfgTree.findLongestBetweenTwoNodes( childNode,tnode);
                     // adding an  invisible edge between the two nodes
                    addEdgeWithNumberOfInvisibleNodes(node, graphNode, Color.BLUE, Color.RED, 2.0f, true, value,lengthOfLongestPath);
                }
                //  checking if the edge is a branch statement (goto,if-then)
                else if(cGraph.isLoopEdge( childNode,parentNode) && (numberOfPaths > 1))
                {
                    // adding an edge between the two nodes
                    addEdgeWithNumberOfInvisibleNodes(node, graphNode, Color.BLUE, Color.RED, 2.0f, true, value,lengthOfLongestPath);
                    
                }else{
                    addEdge(node, graphNode, Color.BLUE, Color.RED, 2.0f, true, value);
                }   
            }
        }

        // setting root node flag for the root node
        findNode(rootNode.getId(), rootNode.getMethodName()).getData().setIsRoot(true);
    }

    public CFGPanel(CGraph cGraph, int width,int height) {
    	super(new ForceDirectedLayout(), width, height);
    	//cGraph=create19NodesGraph();
    	// initializing graph panel
    	// initializing list of nodes
        this.listOfNodes = new ArrayList<Node>();
        
        // Clearing list of points (because it is a static object)
        // Although it will create a problem of we wanted to display two or more graphs simultaneously 
        Point.clearPoints();
        Spring.clearSprings();

        // reading CFG file to get nodes and edges
        this.cGraph = cGraph;
        
        // getting root node
        rootNode = this.cGraph.getRoot();
        

        // drawing CFG
        drawCFGTree();
    }

    public void addEdge(Node node, Node otherNode, Color edgeColor, Color edgeLabelColor, float weight, boolean directed,  CEdgeValue value) {
    	String edgeLabel="";
    	
    	// assigning edge value to label
        if(value != null)
        {
        	 if(value.getExpectedPredicateResult()==1){
        		 edgeLabel = "T";
             }
        	 else  if(value.getExpectedPredicateResult()==0){
        		 edgeLabel = "F";
        	 }
        }
                
    	this.addEdge(node, otherNode,
                new EdgeData().color(edgeColor).labelColor(edgeLabelColor).weight(weight)
                .directional(directed).label(edgeLabel).edgeValue(value));
    }

    public void addEdgeWithNumberOfInvisibleNodes(Node node, Node otherNode, Color edgeColor, Color edgeLabelColor, float weight, boolean directed, CEdgeValue value,int numberOfNodes) {
    	String edgeLabel="";
    	
    	// creating invicible node        
        Node invicibleNode = addInvicibleNode("","", "",Color.BLACK, Color.BLACK, Color.WHITE, 1);
        
        // assigning edge value to label
        if(value != null)
        {
        	if(value.getExpectedPredicateResult()==1){
       		 edgeLabel = "T";
            }
	       	 else  if(value.getExpectedPredicateResult()==0){
	       		 edgeLabel = "F";
	       	 }
        }
        
        // adding edge between first connected node and the invicible node
        this.addEdge(node, invicibleNode,
                new EdgeData().color(edgeColor).labelColor(edgeLabelColor).weight(weight)
                .directional(false).label(edgeLabel).edgeValue(value));
        
        edgeLabel = "";
        
        for(int i=0;i<numberOfNodes-1;i++){
            Node newInvicibleNode = addInvicibleNode("", "", "",Color.BLACK, Color.BLACK, Color.WHITE, 1);
            
            // adding edge between the invicible node and the new invisible node 
            this.addEdge(invicibleNode, newInvicibleNode,
                new EdgeData().color(edgeColor).labelColor(edgeLabelColor).weight(weight).directional(false).label(edgeLabel).isInvisible(true).edgeValue(value));
            
            invicibleNode = newInvicibleNode;
        }
        
         // adding edge between the invicible node and the second connected node
        this.addEdge(invicibleNode, otherNode,
                new EdgeData().color(edgeColor).labelColor(edgeLabelColor).weight(weight)
                .directional(directed).label(edgeLabel).edgeValue(value));

    }
    
    public Node addNode(String label, String mName, String mClass, Color labelColor, Color nodeColor, Color boxColor, float mass) {
        final Node node = this.addNode(new NodeData().label(label).mName(mName).labelColor(labelColor)
                .backgroundColor(nodeColor).boxColor(boxColor).mass(mass).mClass(mClass));
        return node;
    }

    public Node addInvicibleNode(String label, String mName, String mClass,  Color labelColor, Color nodeColor, Color boxColor, float mass) {
        final Node node = this.addNode(new NodeData().label(label).mName(mName).labelColor(labelColor)
                .backgroundColor(nodeColor).boxColor(boxColor).mass(mass).mClass(mClass));
        node.getData().setIsInvicible(true);
        return node;
    }
    
	//http://www.ssw.uni-linz.ac.at/General/Staff/TW/Wuerthinger06Bachelor.pdf
	public CGraph create19NodesGraph() {
		CGraph g = new CGraph();
		CNode node1 = new CNode(0, "MethodA", "ClassA", new CBlock(1), Color.GREEN);
		g.addCNode(node1);
		CNode node2 = new CNode(1, "MethodA", "ClassA", new CBlock(2), Color.GREEN);
		g.addCNode(node2);
		CNode node3 = new CNode(2, "MethodA", "ClassA", new CBlock(3), Color.GREEN);
		g.addCNode(node3);
		CNode node4 = new CNode(3, "MethodA", "ClassA", new CBlock(4), Color.GREEN);
		g.addCNode(node4);
		CNode node5 = new CNode(4, "MethodA", "ClassA", new CBlock(5), Color.GREEN);
		g.addCNode(node5);
		CNode node6 = new CNode(5, "MethodA", "ClassA", new CBlock(6), Color.GREEN);
		g.addCNode(node6);
		CNode node7 = new CNode(6, "MethodA", "ClassA", new CBlock(7), Color.GREEN);
		g.addCNode(node7);
		CNode node8 = new CNode(7, "MethodA", "ClassA", new CBlock(8), Color.GREEN);
		g.addCNode(node8);
		CNode node9 = new CNode(8, "MethodA", "ClassA", new CBlock(9), Color.GREEN);
		g.addCNode(node9);
		CNode node10 = new CNode(9, "MethodA", "ClassA", new CBlock(10), Color.GREEN);
		g.addCNode(node10);
		CNode node11 = new CNode(10, "MethodA", "ClassA", new CBlock(11), Color.GREEN);
		g.addCNode(node11);
		CNode node12 = new CNode(11, "MethodA", "ClassA", new CBlock(12), Color.GREEN);
		g.addCNode(node12);
		CNode node13 = new CNode(12, "MethodA", "ClassA", new CBlock(13), Color.GREEN);
		g.addCNode(node13);
		CNode node14 = new CNode(13, "MethodA", "ClassA", new CBlock(14), Color.GREEN);
		g.addCNode(node14);
		CNode node15 = new CNode(14, "MethodA", "ClassA", new CBlock(15), Color.GREEN);
		g.addCNode(node15);
		CNode node16 = new CNode(15, "MethodA", "ClassA", new CBlock(16), Color.GREEN);
		g.addCNode(node16);
		CNode node17 = new CNode(16, "MethodA", "ClassA", new CBlock(17), Color.GREEN);
		g.addCNode(node17);
		CNode node18 = new CNode(17, "MethodA", "ClassA", new CBlock(18), Color.GREEN);
		g.addCNode(node18);
		CNode node19 = new CNode(18, "MethodA", "ClassA", new CBlock(19), Color.GREEN);
		g.addCNode(node19);
		CNode node20 = new CNode(19, "MethodA", "ClassA", new CBlock(20), Color.GREEN);
		g.addCNode(node20);
		CNode node21 = new CNode(20, "MethodA", "ClassA", new CBlock(21), Color.GREEN);
		g.addCNode(node21);
		

		g.addCEdge(new CEdge(1, node20, node1));
		g.addCEdge(new CEdge(2, node1, node4));
		g.addCEdge(new CEdge(3, node1, node2));
		g.addCEdge(new CEdge(4, node2, node4));
		g.addCEdge(new CEdge(5, node4, node6));
		g.addCEdge(new CEdge(6, node6, node12));
		g.addCEdge(new CEdge(7, node6, node11));
		g.addCEdge(new CEdge(8, node21, node5));
		g.addCEdge(new CEdge(9, node13, node12));
		g.addCEdge(new CEdge(10, node10, node13));
		g.addCEdge(new CEdge(11, node5, node8));
		g.addCEdge(new CEdge(12, node5, node7));
		g.addCEdge(new CEdge(13, node13, node14));
		g.addCEdge(new CEdge(14, node7, node10));
		g.addCEdge(new CEdge(15, node14, node16));
		g.addCEdge(new CEdge(16, node14, node15));
		g.addCEdge(new CEdge(17, node10, node5));
		g.addCEdge(new CEdge(18, node16, node13));
		g.addCEdge(new CEdge(19, node15, node18));
		g.addCEdge(new CEdge(20, node18, node16));
		g.addCEdge(new CEdge(21, node18, node20));
		return g;
	}
}
