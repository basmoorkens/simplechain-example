package com.bm.blockchain;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Block {

	private String data;
	private String previousHash;
	private String hash;
	private Date timeStamp;
	private int index;
	
	private Block (final int index, final String hash, final String previousHash, final String data) {
		this.data = data;
		this.hash = hash;
		this.previousHash = previousHash;
		this.setTimeStamp(new Date());
		this.setIndex(index);
	}

	public static Block mint(final String data, final String lastHash, final int index) throws NoSuchAlgorithmException {
        String hash = Hashing.sha256()
                .hashString(data, StandardCharsets.UTF_8)
                .toString();
		return new Block(index, hash, lastHash, data);
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getPreviousHash() {
		return previousHash;
	}

	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}
}

