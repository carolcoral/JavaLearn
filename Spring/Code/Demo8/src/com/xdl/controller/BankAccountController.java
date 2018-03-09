package com.xdl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xdl.bean.BankAccount;
import com.xdl.service.BankAccountService;

@Controller
public class BankAccountController {
   // 注入Service 对象 
   @Autowired	
   private   BankAccountService  bankAccountService;
   @RequestMapping("/toBankAccountList.do")
   public  String  toBankAccountList(){
	   return  "bank_account_list";
   }
   @RequestMapping("/bankAccountList.do")
   @ResponseBody
   public  List<BankAccount>  bankAccountList(){

	   List<BankAccount>  datas = bankAccountService.listBankAccount();
	   return  datas;
   }
   
   /* @RequestMapping("/bankAccountRemove.do")
   @ResponseBody
   public  boolean bankAccountRemove(HttpServletRequest  request){
	   String ano = request.getParameter("ano");
	   return  bankAccountService.removeAccountByAno(ano);
   } */
   @RequestMapping(value="/account/{ano}",method=RequestMethod.DELETE)
   @ResponseBody
   public  boolean bankAccountRemove(@PathVariable("ano") String  ano){
	   System.out.println("删除 ano=" + ano);
	   return  bankAccountService.removeAccountByAno(ano);
   } 
   @RequestMapping(value="/account/{ano}",method=RequestMethod.GET)
   @ResponseBody
   public  BankAccount bankAccountGet(@PathVariable("ano") String  ano){
	   System.out.println("获取 ano=" + ano);
	   BankAccount  account = bankAccountService.accountInfoByAno(ano);
	   if(account == null){
		   System.out.println("account:"+account);
		   return  null;
	   }else{
		   return account;
	   }
   }
   /** 添加银行账户 */
   @RequestMapping(value="/account/new/{ano}",method=RequestMethod.POST)
   @ResponseBody
   public  boolean   bankAccountAdd(@PathVariable("ano") String ano,
		BankAccount account){
	   return  bankAccountService.createAccount(account);
   }
   
   /** 更新银行账户 */
   @RequestMapping(value="/account/{ano}",method=RequestMethod.POST)
   @ResponseBody
   public  boolean   bankAccountUpdate(@PathVariable("ano") String ano,
		@RequestBody BankAccount account){
	   System.out.println("account:"+account);
	   return  bankAccountService.updateAccount(account);
   }
}





