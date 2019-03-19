package com.test.lambda;



public class JobScheduler {
	  private TransactionHelper transactionHelper = new TransactionHelper();
	 public void run(String s) {
		    try {
		      transactionHelper.doInCurrentTransaction(() -> doFind(s));
		    } catch (Exception e) {
		     System.out.println(e.getMessage());
		    }
		  }
	 
	 private void doFind(String s) {
             System.out.println(s);
	  }
	 public static void main(String[] args) {
		new JobScheduler().run("lambda表达式");
	}
}
