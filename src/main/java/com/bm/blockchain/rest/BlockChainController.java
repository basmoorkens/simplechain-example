package com.bm.blockchain.rest;

import com.bm.blockchain.Block;
import com.bm.blockchain.BlockChain;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
public class BlockChainController {

    private BlockChain blockChain;

    @PostConstruct
    public void init() throws Exception {
        blockChain = BlockChain.createBlockChain();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public BlockChain getBlockChain() {
        return blockChain;
    }

    @RequestMapping(value ="/block/{index}", produces = "application/json")
    public Block getBlock(@PathVariable("index") int index) {
        return blockChain.getBlockByIndex(index);
    }

    @RequestMapping(value ="/lastBlock", produces = "application/json")
    public Block getLastBlock() {
        return blockChain.getLastBlock();
    }

    @RequestMapping(value="/block/add")
    public void addBlock(@RequestParam(value="data") final String data) throws Exception {
        blockChain.addBlock(data);
    }
}
