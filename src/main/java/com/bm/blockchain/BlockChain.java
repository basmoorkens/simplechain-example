package com.bm.blockchain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {

	private List<Block> blocks;
	
	private int index;
	
	private BlockChain() throws Exception {
		blocks = new ArrayList<>();
		index = 0;
		blocks.add(Block.mint("Genesis", "", index++));
	}
	
	public static BlockChain createBlockChain() throws Exception {
		BlockChain blockChain = new BlockChain();
		
		return blockChain;
	}

	public List<Block> getBlocks() {
		return blocks;
	}

	@JsonIgnore
	public Block getLastBlock() {
		return blocks.get(index-1);
	}

	public Block getBlockByIndex(final int index) {
		return blocks.get(index);
	}
	
	public void addBlock(String data) throws Exception {
		blocks.add(Block.mint(data,getLastBlock().getHash(), index++));
	}
}
