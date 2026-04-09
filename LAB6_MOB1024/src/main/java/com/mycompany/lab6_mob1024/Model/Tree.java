/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6_mob1024.Model;

/**
 *
 * @author LENOVO
 */
public class Tree {

    private int nodeId;
    private String nodeName;
    private Integer parentId;
    private int level;

    public Tree() {
    }

    public Tree(int nodeId, String nodeName, Integer parentId, int level) {
        this.nodeId = nodeId;
        this.nodeName = nodeName;
        this.parentId = parentId;
        this.level = level;
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "\nTree: " + "NodeID: " + nodeId + "NodeName: " + nodeName + "ParentId: " + parentId + "Level: " + level;

    }
}
