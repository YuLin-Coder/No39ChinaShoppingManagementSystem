package com.yjg.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.yjg.api.model.Collect;
import com.yjg.api.model.Goods;
import com.yjg.api.model.Seller;
import com.yjg.api.model.User;
import com.yjg.api.service.CollectService;
import com.yjg.api.service.GoodsService;
import com.yjg.api.service.SellerService;
import com.yjg.api.service.UserService;
import com.yjg.util.DateUtil;
import com.yjg.util.FileUtil;
import org.springframework.web.multipart.MultipartFile;


@Controller  
@RequestMapping("/user")  
public class UserController {  
	@Resource
	private CollectService collectService;
	@Resource
	private SellerService sellerService;
	@Resource
	private GoodsService goodsService;
	@Resource
	private UserService userService;
 
      
	@RequestMapping(method = RequestMethod.GET)
    public String toIndex(HttpSession session,Model model){  
        return "user";  
    }
	
	@RequestMapping(value="/getCollect" ,method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
    public String getCollect(HttpServletRequest request,HttpSession session){  
		User user = (User) session.getAttribute("User");
		Integer userId = user.getUserId();
		Collect collect = new Collect();
		collect.setUserId(userId);
		Map<String,Object> reMap=new HashMap<>();
		reMap.put("Collect", collect);
		Map<String,Object> returnMap=new HashMap<>();
		try {
		    returnMap = collectService.selectAllCollect(reMap);
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		} catch (Exception e) {
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
	
	
	@RequestMapping(value = "/remCollect",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String remCollect(HttpServletRequest request,HttpSession session) {
		Integer collectId=Integer.parseInt(request.getParameter("collectId"));
		Collect collect = new Collect();
		collect.setCollectId(collectId);
		Map<String,Object> reMap=new HashMap<>();
		reMap.put("Collect", collect);
		Map<String,Object> returnMap=new HashMap<>();
		try {
		    returnMap = collectService.deletCollect(reMap);
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		} catch (Exception e) {
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
	
	@RequestMapping(value = "/getSeller",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String getSeller(HttpServletRequest request,HttpSession session) {
		User user = (User) session.getAttribute("User");
		Integer userId = user.getUserId();
		Seller seller = new Seller();
		seller.setUserId(userId);
		Map<String,Object> reMap=new HashMap<>();
		reMap.put("Seller", seller);
		Map<String,Object> returnMap=new HashMap<>();
		try {
		    returnMap = sellerService.selectOneSeller(reMap);
		    Gson gson=new Gson();  
	        String gsonStr=gson.toJson(returnMap);
	//		String jsonString = JSON.toJSONString(returnMap);
	        return gsonStr;
		} catch (Exception e) {
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
	
	@RequestMapping(value = "/getProduct",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String getProduct(HttpServletRequest request,HttpSession session) {
		User user = (User) session.getAttribute("User");
		String userName=user.getUserName();
		Goods goods =new Goods();
		goods.setGoodsFrom(userName);
		Map<String,Object> reMap=new HashMap<>();
		reMap.put("Goods", goods);
		Map<String,Object> returnMap=new HashMap<>();
		try {
		    returnMap = goodsService.SelectAllGoods(reMap);
		    Gson gson=new Gson();  
	        String gsonStr=gson.toJson(returnMap);
	//		String jsonString = JSON.toJSONString(returnMap);
	        return gsonStr;
		} catch (Exception e) {
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
	@RequestMapping(value = "/addSeller",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String addSeller(Seller seller,HttpSession session) {
		User user = (User) session.getAttribute("User");
		Integer userId = user.getUserId();
		Map<String, Object> requestmap = new HashMap<>();
		Map<String, Object> returnMap = new HashMap<>();
		try {
			seller.settIdCardUrl1(FileUtil.shangc(seller.getFile1()));
			seller.settIdCardUrl2(FileUtil.shangc(seller.getFile2()));
		} catch (Exception e) {
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
		String timeString = DateUtil.toDateTimeString(new Date());
		seller.setCreateDate(timeString);
		seller.settStatus("10");//
		seller.setUserId(userId);
		requestmap.put("Seller",seller );
		try {
			returnMap = sellerService.addSeller(requestmap);
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		} catch (Exception e) {
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
	
	@RequestMapping(value = "/updateUser",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String updateUser(User user,HttpSession session) {
		User user2 = (User) session.getAttribute("User");
		Integer userId = user2.getUserId();
		Map<String, Object> requestmap = new HashMap<>();
		Map<String, Object> returnMap = new HashMap<>();
		String address=user.getProvince()+"-"+user.getCity()+"-"+user.getDistrict();
		user.setAddress(address);
		String timeString = DateUtil.toDateTimeString(new Date());
		user.setModeDate(timeString);
		user.setUserId(userId);
		requestmap.put("User",user);
		try {
			returnMap = userService.updateUser(requestmap);
			Map<String, Object> map = userService.checkName(requestmap);
			session.setAttribute("User", (User)map.get("RetData"));
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		} catch (Exception e) {
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
	//修改用户密码
	@RequestMapping(value = "/updateUser2",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String updateUser2(HttpServletRequest request,HttpSession session) {
		User user2 = (User) session.getAttribute("User");
		Integer userId = user2.getUserId();
		Map<String, Object> requestmap = new HashMap<>();
		Map<String, Object> returnMap = new HashMap<>();
		String timeString = DateUtil.toDateTimeString(new Date());
		User user = new User();
		user.setPassword(request.getParameter("psaaword"));
		user.setModeDate(timeString);
		user.setUserId(userId);
		requestmap.put("User",user);
		try {
			returnMap = userService.updateUser(requestmap);
			user2.setModeDate(timeString);
			user2.setPassword(request.getParameter("psaaword"));
			session.setAttribute("User", user2);
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		} catch (Exception e) {
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
	
	@RequestMapping(value = "/addGoods",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String addGoods(Goods goods, MultipartFile file1, MultipartFile file2, MultipartFile file3, MultipartFile file4,HttpSession session,HttpServletRequest request) {
		User user = (User) session.getAttribute("User");
		String typename = request.getParameter("pzName");
		String goodsIdZZ = request.getParameter("goodsIdZZ");
		Map<String, Object> requestmap = new HashMap<>();
		Map<String, Object> returnMap = new HashMap<>();
		if(goods.getGoodsPriceZ()==null){
			goods.setIfZK("N");
		}else{
			goods.setIfZK("Y");
		}
		try {
			if (file1 != null) {
				goods.setGoodsUrl(FileUtil.shangc(file1));
			}
			if (file2 != null) {
				goods.setGoodsUrl2(FileUtil.shangc(file2));
			}
			if (file3 != null) {
				goods.setGoodsUrl3(FileUtil.shangc(file3));
			}
			if (file4 != null) {
				goods.setGoodsUrl4(FileUtil.shangc(file4));
			}
		} catch (Exception e) {
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
		String timeString = DateUtil.toDateTimeString(new Date());
		goods.setTypeDid(Integer.parseInt(typename));
		goods.setGoodsFrom(user.getUserName());
		if("N".equals(goods.getIfZK())){
			goods.setGoodsPriceZ(null);
		}
		requestmap.put("Goods",goods );
		try {
			if(goodsIdZZ==null||goodsIdZZ.equals("")){
				goods.setCreateDate(timeString);
				goods.setCreateId(user.getUserId());
				returnMap = goodsService.addGoods(requestmap);
			}else{
				goods.setGoodsId(Integer.parseInt(goodsIdZZ));
				goods.setModeDate(timeString);
				goods.setModeId(user.getUserId());
				returnMap = goodsService.upDateGoods(requestmap);
			}
			
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		} catch (Exception e) {
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
	
	@RequestMapping(value = "/addGoods2",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String addGoods2(Goods goods, MultipartFile file1, MultipartFile file2, MultipartFile file3, MultipartFile file4, HttpSession session, HttpServletRequest request) {
		User user = (User) session.getAttribute("User1");
		String typename = request.getParameter("pzName");
		String goodsIdZZ = request.getParameter("goodsIdZZ");
		Map<String, Object> requestmap = new HashMap<>();
		Map<String, Object> returnMap = new HashMap<>();
		if(goods.getGoodsPriceZ()==null){
			goods.setIfZK("N");
		}else{
			goods.setIfZK("Y");
		}
		try {
			if (file1 != null) {
				goods.setGoodsUrl(FileUtil.shangc(file1));
			}
			if (file2 != null) {
				goods.setGoodsUrl2(FileUtil.shangc(file2));
			}
			if (file3 != null) {
				goods.setGoodsUrl3(FileUtil.shangc(file3));
			}
			if (file4 != null) {
				goods.setGoodsUrl4(FileUtil.shangc(file4));
			}
		} catch (Exception e) {
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
		String timeString = DateUtil.toDateTimeString(new Date());
		goods.setTypeDid(Integer.parseInt(typename));
		goods.setGoodsFrom(user.getUserName());
		if("N".equals(goods.getIfZK())){
			goods.setGoodsPriceZ(null);
		}
		requestmap.put("Goods",goods );
		try {
			if(goodsIdZZ==null||goodsIdZZ.equals("")){
				goods.setCreateDate(timeString);
				goods.setCreateId(user.getUserId());
				returnMap = goodsService.addGoods(requestmap);
			}else{
				goods.setGoodsId(Integer.parseInt(goodsIdZZ));
				goods.setModeDate(timeString);
				goods.setModeId(user.getUserId());
				returnMap = goodsService.upDateGoods(requestmap);
			}
			
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		} catch (Exception e) {
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
	
	@RequestMapping(value = "/remGoods",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String remGoods(HttpServletRequest request,HttpSession session) {
		Integer goodsId=Integer.parseInt(request.getParameter("goodsId"));
		Goods goods = new Goods();
		goods.setGoodsId(goodsId);
		Map<String,Object> reMap=new HashMap<>();
		reMap.put("Goods", goods);
		Map<String,Object> returnMap=new HashMap<>();
		try {
		    returnMap = goodsService.deletGoods(reMap);
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
	
	@RequestMapping(value = "/seletOneGoods",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String seletOneGoods(HttpServletRequest request,HttpSession session) {
		Integer goodsId=Integer.parseInt(request.getParameter("goodsId"));
		Goods goods = new Goods();
		goods.setGoodsId(goodsId);
		Map<String,Object> reMap=new HashMap<>();
		reMap.put("Goods", goods);
		Map<String,Object> returnMap=new HashMap<>();
		try {
		    returnMap = goodsService.SelectOneGoods(reMap);
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		} catch (Exception e) {
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
	@RequestMapping(value = "/seletAllUser",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String seletUser(HttpServletRequest request,HttpSession session) {
		String ifAdmin = request.getParameter("ifAdmin");
		User user = new User();
		if(!"".equals(ifAdmin)){
			user.setIfAdmin(ifAdmin);
		}
		Map<String,Object> reMap=new HashMap<>();
		reMap.put("User", user);
		Map<String,Object> returnMap=new HashMap<>();
		try {
		    returnMap = userService.selectAllUser(reMap);
		//	String jsonString = JSON.toJSONString(returnMap);
		    Gson gson=new Gson();  
	        String gsonStr=gson.toJson(returnMap);
	        return gsonStr;
		} catch (Exception e) {
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
	//分页获取用户列表
	@RequestMapping(value = "/getUserList",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String getUserList(HttpServletRequest request,HttpSession session) {
		Integer pageIndex =Integer.parseInt(request.getParameter("pageIndex"));
		Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));
		Integer startPage=(pageIndex-1)*pageSize;//从多少条开始
		Map<String,Object> hashMap = new HashMap<String,Object>();
		Map<String,Object> returnMap=new HashMap<>();
		hashMap.put("startPage", startPage);
		hashMap.put("pageSize", pageSize);
		try {
			returnMap = userService.selectUserList(hashMap);
			//String jsonString = JSON.toJSONString(returnMap);
			Gson gson=new Gson();  
	        String gsonStr=gson.toJson(returnMap);
			return gsonStr;
		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}

    }
	//密码重置以及授权
	@RequestMapping(value = "/chageUser",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String chageUser(HttpServletRequest request,HttpSession session) {
		User user2 = (User) session.getAttribute("User1");
		String userId=request.getParameter("userId");
		String flag=request.getParameter("flag");
		User user = new User();
		user.setUserId(Integer.parseInt(userId));
		String timeString = DateUtil.toDateTimeString(new Date());
		user.setModeDate(timeString);
		if(flag.equals("0")){
			user.setPassword("111111");
		}else{
			user.setIfAdmin("Y");
			user.setCreateDate(timeString);
			user.setCreatePer(user2.getUserName());
		}
		Map<String,Object> reMap=new HashMap<>();
		reMap.put("User", user);
		Map<String,Object> returnMap=new HashMap<>();
		try {
		    returnMap = userService.updateUser(reMap);
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
	//获取店主列表
	@RequestMapping(value = "/getSellerList",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String getSellerList(HttpServletRequest request,HttpSession session) {
		Integer pageIndex =Integer.parseInt(request.getParameter("pageIndex"));
		Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));
		Integer startPage=(pageIndex-1)*pageSize;//从多少条开始
		Map<String,Object> hashMap = new HashMap<String,Object>();
		Map<String,Object> returnMap=new HashMap<>();
		hashMap.put("startPage", startPage);
		hashMap.put("pageSize", pageSize);
		try {
			returnMap = sellerService.selectSellerList(hashMap);
			//String jsonString = JSON.toJSONString(returnMap);
			Gson gson=new Gson();  
	        String gsonStr=gson.toJson(returnMap);
			return gsonStr;
		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}

    }
	//获取店主信息
	@RequestMapping(value = "/getSeller2",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String getSeller2(HttpServletRequest request,HttpSession session) {
		String sellerId=request.getParameter("sellerId");
		Seller seller = new Seller();
		seller.setSellerId(Integer.parseInt(sellerId));
		Map<String,Object> reMap=new HashMap<>();
		reMap.put("Seller", seller);
		Map<String,Object> returnMap=new HashMap<>();
		try {
		    returnMap = sellerService.selectOneSeller(reMap);
		    Gson gson=new Gson();  
	        String gsonStr=gson.toJson(returnMap);
	//		String jsonString = JSON.toJSONString(returnMap);
	        return gsonStr;
		} catch (Exception e) {
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
	//审核不通过
	@RequestMapping(value = "/delSeller",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String delSeller(HttpServletRequest request,HttpSession session) {
		String sellerId=request.getParameter("sellerId");
		Seller seller = new Seller();
		seller.setSellerId(Integer.parseInt(sellerId));
		Map<String,Object> reMap=new HashMap<>();
		reMap.put("Seller", seller);
		Map<String,Object> returnMap=new HashMap<>();
		try {
		    returnMap = sellerService.deletSeller(reMap);
		    Gson gson=new Gson();  
	        String gsonStr=gson.toJson(returnMap);
	//		String jsonString = JSON.toJSONString(returnMap);
	        return gsonStr;
		} catch (Exception e) {
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
	//审核通过
	@RequestMapping(value = "/updateSeller",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String updateSeller(HttpServletRequest request,HttpSession session) {
		String sellerId=request.getParameter("sellerId");
		Seller seller = new Seller();
		seller.setSellerId(Integer.parseInt(sellerId));
		String timeString = DateUtil.toDateTimeString(new Date());
		seller.setModeDate(timeString);
		seller.settStatus("20");
		Map<String,Object> reMap=new HashMap<>();
		reMap.put("Seller", seller);
		Map<String,Object> returnMap=new HashMap<>();
		try {
		    returnMap = sellerService.upDateSeller(reMap);
		    Gson gson=new Gson();  
	        String gsonStr=gson.toJson(returnMap);
	//		String jsonString = JSON.toJSONString(returnMap);
	        return gsonStr;
		} catch (Exception e) {
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
	//判断密码
	@RequestMapping(value = "/checkPassword",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String checkPassword(@RequestParam String passwordold,HttpSession session) {
		User user = (User) session.getAttribute("User");
        boolean result = true;
        if(!user.getPassword().equals(passwordold)){
        	result=false;
        }
        Map<String, Boolean> map = new HashMap<>();
        map.put("valid", result);
        String jsonString = JSON.toJSONString(map);
        return jsonString;
    }
}  