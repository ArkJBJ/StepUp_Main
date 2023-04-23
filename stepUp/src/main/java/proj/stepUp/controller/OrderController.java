package proj.stepUp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import proj.stepUp.service.OrderItemService;
import proj.stepUp.service.OrderService;
import proj.stepUp.service.SizeService;
import proj.stepUp.service.UserService;
import proj.stepUp.util.PagingUtil;
import proj.stepUp.vo.OrderItemVO;
import proj.stepUp.vo.OrderVO;
import proj.stepUp.vo.SearchVO;
import proj.stepUp.vo.SizeVO;
import proj.stepUp.vo.UserVO;

@RequestMapping(value="/order")
@Controller
public class OrderController {
	
	@Autowired
	private OrderService orederService;
	@Autowired
	private OrderItemService orderItemService;
	@Autowired
	private SizeService sizeService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "manager.do", method = RequestMethod.GET)
	public String managerOrderList() {
				
		return "order/manager";
	}
	
	@RequestMapping(value = "managerInfo.do", method = RequestMethod.GET)
	public String managerInfo(int orderIndex, Model model) {
		
		OrderVO orderVO = orederService.selectByOrderIndex(orderIndex);
		List<OrderItemVO> orderItemVO = orderItemService.selectOrderInfo(orderIndex);
		model.addAttribute("orderVO", orderVO);
		model.addAttribute("orderItemVO", orderItemVO);
		
		return "order/managerInfo";
	}
	
	@RequestMapping(value = "payment.do", method = RequestMethod.GET)
	public String payment(int userIndex, int[] sizeIndex, int[] sizeStock, Model model) {
		
			List<SizeVO> sizeVO = new ArrayList<SizeVO>();
			List<Integer> stock = new ArrayList<Integer>();
			UserVO userVO = userService.selectIndex(userIndex);
			for(int i = 0; i < sizeIndex.length; i++) {

				SizeVO vo = sizeService.selectSizeIndex(sizeIndex[i]);
				sizeVO.add(vo);
				stock.add(sizeStock[i]);
			}
			
			model.addAttribute("userVO", userVO);
			model.addAttribute("sizeVO", sizeVO);
			model.addAttribute("stock", stock);
			
		return "order/payment";
	}
	
	@RequestMapping(value = "user.do", method = RequestMethod.GET)
	public String userOrder() {		
		
		return "order/user";
	}
	
	@RequestMapping(value = "userOrderInfo.do", method = RequestMethod.GET)
	public String userOrderInfo(int orderIndex, Model model) {
		OrderVO orderVO = orederService.selectByOrderIndex(orderIndex);
		List<OrderItemVO> orderItemVO = orderItemService.selectOrderInfo(orderIndex);
		model.addAttribute("orderVO", orderVO);
		model.addAttribute("orderItemVO", orderItemVO);
		
		return "order/user_order_info";
	}
	
	@RequestMapping(value = "paymentOk.do", method = RequestMethod.GET)
	public String paymentOk() {		
		
		return "order/paymentOk";
	}
}
