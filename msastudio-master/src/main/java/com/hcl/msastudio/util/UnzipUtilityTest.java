package com.hcl.msastudio.util;

/**
 * A console application that tests the UnzipUtility class
 *
 * @author www.codejava.net
 *
 */
public class UnzipUtilityTest {
	private static final String zipFilePath = "D://MSA Project//tempProj//dentalcare_api.zip";
	private static final String destDirectory = "D://MSA Project//tempProj";
	public static void main(String[] args) {

		UnzipUtility unzipper = new UnzipUtility();

		try {
			unzipper.unzip(zipFilePath, destDirectory);
		} catch (Exception ex) {
			// some errors occurred
			ex.printStackTrace();
		}
	}

}
