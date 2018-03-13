package com.xdl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xdl.bean.BankAccount;
import com.xdl.service.BankAccountService;

@Controller
public class BankAccountController {
   // ◊¢»ÎService ∂‘œÛ 
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
   
   @RequestMapping("/bankAccountRemove.do")
   @ResponseBody
   public  boolean bankAccountRemove(HttpServletRequest  request){
	   String ano = request.getParameter("ano");
	   return  bankAccountService.removeAccountByAno(ano);
   }
}
