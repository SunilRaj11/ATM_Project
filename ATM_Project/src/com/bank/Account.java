package com.bank;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Account
{
//private
	//non-static data members
	private int customerNumber;
	private int pinNumber;
	private double checkingBalance = 0.0;
	private double savingBalance=0.0;

	Scanner input=new Scanner(System.in);
	//ctrl +_alt+4 for rupee symbol shortcut
    DecimalFormat moneyFormat=new DecimalFormat("'₹'###,##0.00");

    public Account()
    {

    }
    public Account(int customerName, int pinNumber)
    {
    	this.customerNumber = customerNumber;
    	this.pinNumber=pinNumber;
    }
    public Account(int customerNUmber, int pinNumber,double checkingBalance, double savingBalance)
    {
    	this.customerNumber =customerNumber;
    	this.pinNumber = pinNumber;
    	this.checkingBalance =checkingBalance;
    	this.savingBalance=savingBalance;

    }
    //if we want to access private datamembers set method is used
    public int setCustomerNumber(int CustomerNumber)
    {
    	this.customerNumber = customerNumber;
    	return customerNumber;

    }
    public int getCustomerNumber()
    {
    	return customerNumber;
    	}
	public int getPinNumber()
	{
		return pinNumber;
	}
	public void setPinNumber(int pinNumber)
	{
		this.pinNumber = pinNumber;
	}
	public double getCheckBalance()
	{
		return checkingBalance;
	}
	public double getSavingBalance()
	{
		return savingBalance;
	}
	public double calcCheckingWithdraw(double amount)
	{
		checkingBalance  =(checkingBalance - amount);
		return checkingBalance;

	}
	public double calcSavingWithdraw(double amount)
	{
		savingBalance =(savingBalance - amount);
		return savingBalance;
	}
	public double calcCheckingDeposit(double amount)
	{
		checkingBalance = (checkingBalance + amount);
		return checkingBalance;
	}
	public double calcSavingDeposit(double amount)
	{
		savingBalance =(savingBalance + amount);
		return savingBalance;

	}
	//transferring the money from checking to saving
	public void calcCheckTransfer(double amount)
	{
		checkingBalance = checkingBalance - amount;
		savingBalance = savingBalance + amount;
	}
	public void calcSavingTransfer(double amount)
	{
		savingBalance = savingBalance - amount;
		checkingBalance = checkingBalance + amount;

	}
//to get a input from inputs
	public void getCheckingWithdrawInput()
	{
		boolean end = false;

		while(!end)
		{
			try

			{
			System.out.println("\n current checking account balance:" +moneyFormat.format(checkingBalance));
			System.out.println("\n amount you want to withdraw from checkings Account:");
			double amount=input.nextDouble();
	if((checkingBalance-amount)>=0 && amount >= 0)
      {
	    calcCheckingWithdraw(amount);
	    System.out.println("\n current checking account balance:" +moneyFormat.format(checkingBalance));
        end = true;
      }
      else
      {
    	  System.out.println("\n Balance Cannot be Negative");

			}
			}
			catch(InputMismatchException ex)
			{
				System.out.println("\n invalid choice ");
				input.next();

			}
		}


	}
	public void getSavingWithdrawInput()
	{
		boolean end = false;

		while(!end)
		{
			try

			{
			System.out.println("\n current Saving account balance:" +moneyFormat.format(savingBalance));
			System.out.println("\n amount you want to withdraw from Savings Account:");
			double amount=input.nextDouble();
	if((savingBalance-amount)>=0 && amount >= 0)
      {
	    calcSavingWithdraw(amount);
	    System.out.println("\n current saving account balance:" +moneyFormat.format(savingBalance));
        end = true;
      }
      else
      {
    	  System.out.println("\n Balance Cannot be Negative");

			}
			}
			catch(InputMismatchException ex)
			{
				System.out.println("\n invalid choice ");
				input.next();

			}
		}
				}
	public void getCheckingDepositInput()
	{
boolean end = false;

		while(!end)
		{
			try

			{
			System.out.println("\n current checking account balance:" +moneyFormat.format(checkingBalance));
			System.out.println("\n amount you want to withdraw from checkings Account:");
			double amount=input.nextDouble();

	     if(!(amount <= 0)&&(checkingBalance + amount)>=0 && amount >= 0)
      {
	    calcCheckingDeposit(amount);
	    System.out.println("\n current checking account balance:" +moneyFormat.format(checkingBalance));
        end = true;
      }
      else
      {
    	  System.out.println("\n  Cannot be Negative amount");

			}
			}
			catch(InputMismatchException ex)
			{
				System.out.println("\n invalid choice ");
				input.next();

			}
		}

	}
	public void getSavingDepositInput()
	{
		boolean end = false;

		while(!end)
		{
			try

			{
			System.out.println("\n current Saving account balance:" +moneyFormat.format(savingBalance));
			System.out.println("\n amount you want to withdraw from Savings Account:");
			double amount=input.nextDouble();
			if(amount < 0)
			{
				 System.out.println("\n Balance Cannot be Negative");
			}
	if(!(amount <= 0)&&(savingBalance-amount)>=0 && amount >= 0)
      {
	    calcSavingDeposit(amount);
	    System.out.println("\n current saving account balance:" +moneyFormat.format(savingBalance));
        end = true;
      }
      else
      {
    	  System.out.println("\n Balance Cannot be Negative");

			}
			}
			catch(InputMismatchException ex)
			{
				System.out.println("\n invalid choice ");
				input.next();

			}
		}
				}
	public void getTransferInput(String accType)
	{
		boolean end = false;

		while(!end)
		{
			try
			{
				if(accType.equals("checking"))
				{
					System.out.println("\n select an account you wish to transfer funds to:");
					System.out.println("1.savings");
					System.out.println("2.Exit");
					System.out.println("\nChoice:");
					int choice = input.nextInt();
					switch(choice)
					{
					case 1:System.out.println("\n current checking account balance:"+ moneyFormat.format(checkingBalance));
					System.out.println("amount want to deposit into your savings account :");
					double amount = input.nextDouble();
					if((savingBalance + amount)>= 0 && (checkingBalance-amount) >=0 && amount >= 0)
					{
						calcCheckTransfer(amount);
						System.out.println("\n current savings account Balance "+moneyFormat.format(savingBalance));
						System.out.println("\ncurrent checkings account Balance "+moneyFormat.format(checkingBalance));
				        end =true;
					}
					else
					{
						System.out.println("\n  cannot transfer neagative or 0 amount");
					}
					break;
					case 2:
						return;
						default:
							System.out.println("\n invalid choice");
							break;
					}
				}

					else if (accType.equals("Savings"))
					{
						System.out.println("\n select an amount you wish to transfer funds to: ");
						System.out.println("1.checkings");
						System.out.println("2.Exit");
						System.out.println("\nChoice:");
						int choice = input.nextInt();
						switch(choice)
						{
						case 1:System.out.println("\n current saving account balance:"+ moneyFormat.format(savingBalance));
						System.out.println("amount want to deposit into your savings account :");
						double amount = input.nextDouble();
						if(!(amount < 0)&&(checkingBalance + amount)> 0 &&(savingBalance - amount)> 0 && amount >=0)
						{
							calcSavingTransfer(amount);
							System.out.println("\n current checking account balance "+ moneyFormat.format(checkingBalance));
							System.out.println("\n current checking account balance "+moneyFormat.format(savingBalance));
						end = true;
						}
						else
						{
							System.out.println("\n cannot Transfer negative or ) amount");
						}
					break;
						case 2:
							return;
							default:
								System.out.println("\n invaliod choice");
								break;
						}
						}
						}
					catch(InputMismatchException ex)
					{
						System.out.println("\n Invalid Choice");
						input.next();
					}

					}

					}








}