package com.saurav.game;

import java.util.Scanner;

public class Game 
{
	public static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int n,i,l,l2,j,k,f=0;
		String a[][];
		int sr,scol,root;
		double r;
		String str,input[],start[];
		do
		{
			f=0;
			System.out.println("Enter your inputs in directions(N,S,E,W,NE,NW,SE,SW) with ',' after each direction:");
			str=sc.next();
			input=str.split(",");
			l=str.length();
			l2=input.length;
		
			i=0;
			r=Math.sqrt(l2);
			root=(int)Math.floor(r);
			if((root*root)!=l2&&((root+1)*(root+1))!=l2)
			{
				f=1;
				System.out.println("Invalid input!!");
			}
		}while(f==1);
		
		for(i=0;i<l2;i++)
		{
			if(input[i].equals("N")||input[i].equals("S")||input[i].equals("E")||input[i].equals("W")||input[i].equals("NE")||input[i].equals("NW")||input[i].equals("SE")||input[i].equals("SW"))
				f=0;
			else
			{
				f=1;
				System.out.println("Enter valid inputs(N,S,E,W,NE,NW,SE,SW) in "+(i+1)+"th position:");
				input[i]=sc.next();
			}
		}
		
		k=0;
		n=root;
		a=new String[n][n];
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
				a[i][j]=input[k++];
		}
		
		System.out.println("Game template:");
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
				System.out.print(a[i][j]+"  ");
			System.out.println();
		}
		
		f=0;
		do
		{
			System.out.println("Enter start position:");
			str=sc.next();
			start=str.split(",");
			sr=Integer.parseInt(start[0]);
			scol=Integer.parseInt(start[1]);
			if(sr<0||sr>=n||scol<0||scol>=n)
				f=1;
		}while(f==1);
		
		f=0;
		i=sr;
		j=scol;
		while(i<n&&j<n)
		{
				if(a[i][j].equals("0"))
				{
					f=2;
					break;
				}
					
				
				else if(a[i][j].equals("N"))
				{
					a[i][j]="0";
					i--;
				}
				else if(a[i][j].equals("S"))
				{
					a[i][j]="0";
					i++;
				}
				else if(a[i][j].equals("E"))
				{
					a[i][j]="0";
					j++;
				}
				else if(a[i][j].equals("W"))
				{
					a[i][j]="0";
					j--;
				}
				else if(a[i][j].equals("NE"))
				{
					a[i][j]="0";
					i--;
					j++;
				}
				else if(a[i][j].equals("NW"))
				{
					a[i][j]="0";
					i--;
					j--;
				}
				else if(a[i][j].equals("SE"))
				{
					a[i][j]="0";
					i++;
					j++;
				}
				else if(a[i][j].equals("SW"))
				{
					a[i][j]="0";
					i++;
					j--;
				}
				if(i<0||j<0)
				{
					f=1;
					break;
				}
				else if(i>=n||j>=n)
				{
					f=0;
					break;
				}
		}
		
		if(f==0)
			System.out.println("Win");
		else if(f==1)
			System.out.println("Loose");
		else if(f==2)
			System.out.println("Cyclic");
			
		
	}

}
