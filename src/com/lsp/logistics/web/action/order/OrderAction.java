package com.lsp.logistics.web.action.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lsp.logistics.entity.CostomerEntity;
import com.lsp.logistics.entity.GoodsEntity;
import com.lsp.logistics.entity.GoodsNumberEntity;
import com.lsp.logistics.entity.GoodsReturnDetail;
import com.lsp.logistics.entity.OrderDetailEntity;
import com.lsp.logistics.entity.OrderEntity;
import com.lsp.logistics.entity.OrderReturnEntity;
import com.lsp.logistics.service.ifac.CostomerService;
import com.lsp.logistics.service.ifac.goods.GoodsServiceIfac;
import com.lsp.logistics.service.ifac.order.GoodsReturnDetailServiceIfac;
import com.lsp.logistics.service.ifac.order.GoodsReturnEntityServiceIfac;
import com.lsp.logistics.service.ifac.order.OrderDetailServiceIfac;
import com.lsp.logistics.service.ifac.order.OrderReturnServiceIfac;
import com.lsp.logistics.service.ifac.order.OrderServiceIfac;
import com.lsp.logistics.service.ifac.storage.GoodsNumberServiceIfac;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport {
	private List<OrderEntity> orderList;
	private OrderEntity order;
	private CostomerEntity costomer;
	private Integer costomerId;
	private List<GoodsEntity> goodsList;
	private GoodsEntity goods;
	private List<Integer> buyGoodsList;
	private Map<String, Object> data;
	private Integer goodsNumber;
	private List<Integer> buyGoodsNumberList;
	private List<GoodsEntity> goodsNameList;
	private Double goodsAllMoney;
	private Integer costomerId23;
	private String orderId;
	private String orderType;
	private String orderState;
	private String costomerName;
	private String costomerMobailPhone;
	private String orderBeginDate;
	private String orderEndDate;
	private List<GoodsNumberEntity> goodsNumberList;
	private List<OrderDetailEntity> orderDetailList;
	private Integer id;
	private OrderReturnEntity orderReturn;
	private OrderDetailEntity orderDetail;
	private List<Integer> returnGoodsList;//用来装退货的商品ID
	private List<Integer> returnGoodsNumberList;//用例装退货的商品数量

	public List<Integer> getReturnGoodsList() {
		return returnGoodsList;
	}

	public void setReturnGoodsList(List<Integer> returnGoodsList) {
		this.returnGoodsList = returnGoodsList;
	}

	public List<Integer> getReturnGoodsNumberList() {
		return returnGoodsNumberList;
	}

	public void setReturnGoodsNumberList(List<Integer> returnGoodsNumberList) {
		this.returnGoodsNumberList = returnGoodsNumberList;
	}

	public OrderDetailEntity getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetailEntity orderDetail) {
		this.orderDetail = orderDetail;
	}

	public OrderReturnEntity getOrderReturn() {
		return orderReturn;
	}

	public void setOrderReturn(OrderReturnEntity orderReturn) {
		this.orderReturn = orderReturn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<OrderDetailEntity> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetailEntity> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	public List<GoodsNumberEntity> getGoodsNumberList() {
		return goodsNumberList;
	}

	public void setGoodsNumberList(List<GoodsNumberEntity> goodsNumberList) {
		this.goodsNumberList = goodsNumberList;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getCostomerName() {
		return costomerName;
	}

	public void setCostomerName(String costomerName) {
		this.costomerName = costomerName;
	}

	public String getCostomerMobailPhone() {
		return costomerMobailPhone;
	}

	public void setCostomerMobailPhone(String costomerMobailPhone) {
		this.costomerMobailPhone = costomerMobailPhone;
	}

	public String getOrderBeginDate() {
		return orderBeginDate;
	}

	public void setOrderBeginDate(String orderBeginDate) {
		this.orderBeginDate = orderBeginDate;
	}

	public String getOrderEndDate() {
		return orderEndDate;
	}

	public void setOrderEndDate(String orderEndDate) {
		this.orderEndDate = orderEndDate;
	}

	public Integer getCostomerId23() {
		return costomerId23;
	}

	public void setCostomerId23(Integer costomerId23) {
		this.costomerId23 = costomerId23;
	}

	public Double getGoodsAllMoney() {
		return goodsAllMoney;
	}

	public void setGoodsAllMoney(Double goodsAllMoney) {
		this.goodsAllMoney = goodsAllMoney;
	}

	public List<GoodsEntity> getGoodsNameList() {
		return goodsNameList;
	}

	public void setGoodsNameList(List<GoodsEntity> goodsNameList) {
		this.goodsNameList = goodsNameList;
	}

	public List<Integer> getBuyGoodsNumberList() {
		return buyGoodsNumberList;
	}

	public void setBuyGoodsNumberList(List<Integer> buyGoodsNumberList) {
		this.buyGoodsNumberList = buyGoodsNumberList;
	}

	public Integer getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public List<Integer> getBuyGoodsList() {
		return buyGoodsList;
	}

	public void setBuyGoodsList(List<Integer> buyGoodsList) {
		this.buyGoodsList = buyGoodsList;
	}

	public GoodsEntity getGoods() {
		return goods;
	}

	public void setGoods(GoodsEntity goods) {
		this.goods = goods;
	}

	public List<GoodsEntity> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<GoodsEntity> goodsList) {
		this.goodsList = goodsList;
	}

	public Integer getCostomerId() {
		return costomerId;
	}

	public void setCostomerId(Integer costomerId) {
		this.costomerId = costomerId;
	}

	public CostomerEntity getCostomer() {
		return costomer;
	}

	public void setCostomer(CostomerEntity costomer) {
		this.costomer = costomer;
	}

	public List<OrderEntity> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderEntity> orderList) {
		this.orderList = orderList;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	private OrderServiceIfac orderService;
	private CostomerService costomerService;
	private GoodsServiceIfac goodsService;
	private OrderDetailServiceIfac orderDetailService;
	private GoodsNumberServiceIfac goodsNumberService;
	private OrderReturnServiceIfac orderReturnService;
	private GoodsReturnDetailServiceIfac goodsReturnDetailService;
	private GoodsReturnEntityServiceIfac goodsReturnService;

	public void setGoodsReturnService(
			GoodsReturnEntityServiceIfac goodsReturnService) {
		this.goodsReturnService = goodsReturnService;
	}

	public void setGoodsReturnDetailService(
			GoodsReturnDetailServiceIfac goodsReturnDetailService) {
		this.goodsReturnDetailService = goodsReturnDetailService;
	}

	public void setOrderReturnService(OrderReturnServiceIfac orderReturnService) {
		this.orderReturnService = orderReturnService;
	}

	public void setGoodsNumberService(GoodsNumberServiceIfac goodsNumberService) {
		this.goodsNumberService = goodsNumberService;
	}

	public void setOrderDetailService(OrderDetailServiceIfac orderDetailService) {
		this.orderDetailService = orderDetailService;
	}

	public void setGoodsService(GoodsServiceIfac goodsService) {
		this.goodsService = goodsService;
	}

	public void setCostomerService(CostomerService costomerService) {
		this.costomerService = costomerService;
	}

	public void setOrderService(OrderServiceIfac orderService) {
		this.orderService = orderService;
	}

	/*
	 * 进入新建订单页面
	 */
	public String openOrderDetail() {
		goodsList = goodsService.findAllGoods();
		goodsNumberList = goodsNumberService.findAll();
		//把客户Id放进session中，以便在生成订单的时候拿到Id，从而找到客户，set到order中
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session = req.getSession();
		if (costomerId != null) {
			session.setAttribute("costomerId", costomerId);
		}
		return "openOrderDetail";
	}

	/*
	 * 往购物车里添加商品
	 */
	@SuppressWarnings("unchecked")
	public String orderDetailAdd() {

		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session = req.getSession();
		
		//首先得判断库存数量是否足够
		//1、获得商品ID
		//2、通过商品ID获得商品的库存量信息
		//3、获得想要购买的商品数量，并与商品库存中的可分配量作比较
		//4、如果想要购买的数量比可分配量少的话，可以购买,并在库存中减去购买的数量
		//5、如果想要购买的数量比可分配量大的话，给出提示信息--库存不足
		
		Integer goodsid1 = goods.getId();
		GoodsEntity goods1 = goodsService.findGoodsById(goodsid1);
		GoodsNumberEntity goodsNumber1 = (GoodsNumberEntity) goodsNumberService.findShortGoodsNumber(goods1).get(0);
		if(goodsNumber1.getCanDistributeQuantity() > goodsNumber){
			this.goodsNumberService.updateInOrderDetail(goodsid1, goodsNumber);
		} else{
			data = new HashMap<String, Object>();
			data.put("statusCode", "300");
			data.put("message", "商品库存不足");
			return "errorGoodsNumber";
		}

		boolean a = false;// 判断购物车是否存在该商品，true表示已存在，false表示不存在
		int b = 0;// 找出当购物车存在该商品时在购物车的序列

		// 把购买的商品id放进session里
		buyGoodsList = new ArrayList<Integer>();
		if ((ArrayList<Integer>) session.getAttribute("buyGoodsList") != null) {
			buyGoodsList.addAll((ArrayList<Integer>) session
					.getAttribute("buyGoodsList"));
		}

		// 把相对应的商品数量放进session里
		buyGoodsNumberList = new ArrayList<Integer>();
		if ((ArrayList<Integer>) session.getAttribute("buyGoodsNumberList") != null) {
			buyGoodsNumberList.addAll((ArrayList<Integer>) session
					.getAttribute("buyGoodsNumberList"));
		}

		// 判断该商品是否第一次添加，如果不是，商品不用再次添加在session里，直接把数量相加
		// 1、首先得拿到商品session和购买的商品
		// 2、遍历商品List，和打算购买的商品作比较
		// 3、把数量相加

		// 判断是否第一次往购物车添加商品
		if (buyGoodsList.size() == 0) {
			buyGoodsList.add(goods.getId());
			buyGoodsNumberList.add(goodsNumber);
		} else {
			for (int i = 0; i < buyGoodsList.size(); i++) {
				// 如果购物车已存在该商品
				if (buyGoodsList.get(i) == goods.getId()) {
					a = true;
					b = i;
				} else {
					// 购物车不存在该商品

				}
			}

			if (a != true) {
				buyGoodsList.add(goods.getId());
				buyGoodsNumberList.add(goodsNumber);

			} else {
				buyGoodsNumberList.set(b, buyGoodsNumberList.get(b)
						+ goodsNumber);
			}
		}

		session.removeAttribute("buyGoodsNumberList");
		session.setAttribute("buyGoodsNumberList", buyGoodsNumberList);

		session.removeAttribute("buyGoodsList");
		session.setAttribute("buyGoodsList", buyGoodsList);

		// 遍历商品id，找出商品
		goodsNameList = new ArrayList<GoodsEntity>();
		for (int i = 0; i < buyGoodsList.size(); i++) {
			goodsNameList.add(goodsService.findGoodsById(buyGoodsList.get(i)));
		}
		session.removeAttribute("goodsNameList");
		session.setAttribute("goodsNameList", goodsNameList);

		data = new HashMap<String, Object>();
		data.put("statusCode", 200);
		data.put("message", "添加成功");
		data.put("navTabId", "orderDetailList");
		data.put("rel", "");
		data.put("callbackType", "forward");
		data.put("forwardUrl", "openOrderDetail.action");
		return "orderDetailAdd";
	}

	/*
	 * 跳转新订订单页面
	 */
	public String operAddOrderPage() {
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session = req.getSession();
		buyGoodsList = new ArrayList<Integer>();
		if ((ArrayList<Integer>) session.getAttribute("buyGoodsList") != null) {
			buyGoodsList.addAll((ArrayList<Integer>) session
					.getAttribute("buyGoodsList"));
		}
		goodsNameList = new ArrayList<GoodsEntity>();
		for (int i = 0; i < buyGoodsList.size(); i++) {
			goodsNameList.add(goodsService.findGoodsById(buyGoodsList.get(i)));
		}
		buyGoodsNumberList = new ArrayList<Integer>();
		if ((ArrayList<Integer>) session.getAttribute("buyGoodsNumberList") != null) {
			buyGoodsNumberList.addAll((ArrayList<Integer>) session
					.getAttribute("buyGoodsNumberList"));
		}

		// 计算出订单的总金额
		goodsAllMoney = 0.0;
		for (int i = 0; i < goodsNameList.size(); i++) {
			GoodsEntity ac = new GoodsEntity();

			ac = goodsNameList.get(i);

			goodsAllMoney = (Double) (goodsAllMoney + ac.getGoodsPrice()
					* buyGoodsNumberList.get(i));
		}
		
		//把订单总金额放进session中，等到生成订单的时候，吧金额set进order中
		session.removeAttribute("goodsAllMoney");
		session.setAttribute("goodsAllMoney", goodsAllMoney);
		
		return "operAddOrderPage";
	}

	/*
	 * 新订订单
	 */
	public String addOrder() {
		data = new HashMap<String, Object>();
		if (this.orderService.saveOrder(order)) {
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "costomerList");
			data.put("rel", "");
			data.put("callbackType", "closeCurrent");
			data.put("forwardUrl", "");
		} else {
			data.put("statusCode", "300");
			data.put("message", "添加失败");
		}

		return "add";
	}

	/*
	 * 查询所有订单
	 */
	public String findAllOrder() {
		orderList = this.orderService.findAllOrder();
			return "findAllOrder";
	}
	
	/*
	 * 按条件查询订单
	 */
	public String findOrder(){
		orderList = orderService.findOrder(orderId, orderType, orderState, costomerName, costomerMobailPhone, orderBeginDate, orderEndDate);
		if(orderList.size() == 0){
			data = new HashMap<String, Object>();
			data.put("statusCode", "300");
			data.put("message", "查询失败");
			return "errorFindOrder";
		}
		else{
			return "find";
		}
	}
	
	/*
	 * 通过订单Id查询订单详细
	 */
	public String findOrderDetailByOrder(){
		orderDetailList = this.orderDetailService.findByOrder(id);
		return "findOrderDetailByOrder";
	}
	
	/*
	 * 跳转订单退订页面
	 */
	public String orderReturn(){
		order = this.orderService.findById(order.getId());
		orderDetailList = this.orderDetailService.findByOrder(order.getId());
		if(order.getOrderState().equals("订单已确认，等待调度。")){
			return "orderReturn";
		}
		else{
			data = new HashMap<String, Object>();
			data.put("statusCode", "300");
			data.put("message", "退订失败！");
			return "error";
		}
	}
	
	/*
	 * 订单退订
	 */
	public String order_return(){
		data = new HashMap<String, Object>();
		if(this.orderReturnService.save(orderReturn, orderReturn.getOrder().getId())){
			orderService.orderReturn(orderReturn.getOrder().getId());
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "orderList");
			data.put("rel", "");
			data.put("callbackType", "closeCurrent");
			data.put("forwardUrl", "");
		} else {
			data.put("statusCode", "300");
			data.put("message", "申请退订失败！");
		}

		return "order_return";
	}
	
	public String goodsReturn(){
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session = req.getSession();
		Integer goodsReturnOrderId = 0;
		if((Integer)session.getAttribute("goodsReturnOrderId") != null) {
			goodsReturnOrderId = (Integer) session.getAttribute("goodsReturnOrderId");
		} else{
			goodsReturnOrderId = order.getId();
			session.removeAttribute("goodsReturnOrderId");
			session.setAttribute("goodsReturnOrderId", goodsReturnOrderId);
		}
		
		
		order = this.orderService.findById(goodsReturnOrderId);
		orderDetailList = this.orderDetailService.findByOrder(order.getId());
		if(order.getOrderState().equals("配送完成。")){
			return "goodsReturn";
		}
		else{
			data = new HashMap<String, Object>();
			data.put("statusCode", "300");
			data.put("message", "申请退货失败！");
			return "error";
		}
	}
	
	public String goodsReturnDetailAdd(){
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session = req.getSession();
		data = new HashMap<String, Object>();
		Integer inputGoodsNum = goodsNumber;//输入的退货商品数量
		OrderDetailEntity orderDetail1 = orderDetailService.findById(orderDetail.getId());//获得订单详细
		Integer orderDetailGoodsNum = orderDetail1.getGoodsNumber();//获得订单详细的货物数量
		
		//从退货订单详细中查找是否存在该订单详细
		//false表示没有存在
		//true表示已经存在

		if(goodsReturnDetailService.findByOrderDetail(orderDetail.getId()).size() >= 0){
			//没有存在退货订单详细，直接比较输入的退货数量和订单货物数量
			//如果为真，表示输入退货数量有效，则把相关信息放进session中，等到退货时再生成订单详细
			if(orderDetailGoodsNum >= goodsNumber){

				boolean a = false;// 判断购物车是否存在该商品，true表示已存在，false表示不存在
				int b = 0;// 找出当购物车存在该商品时在购物车的序列
				returnGoodsList = new ArrayList<Integer>();
				if ((ArrayList<Integer>) session.getAttribute("returnGoodsList") != null) {
					returnGoodsList.addAll((ArrayList<Integer>) session
							.getAttribute("returnGoodsList"));
				}

				// 把相对应的商品数量放进session里
				returnGoodsNumberList = new ArrayList<Integer>();
				if ((ArrayList<Integer>) session.getAttribute("returnGoodsNumberList") != null) {
					returnGoodsNumberList.addAll((ArrayList<Integer>) session
							.getAttribute("returnGoodsNumberList"));
				}
				
				//判断是否第一次添加退货商品
				if(returnGoodsList.size() ==0){
					returnGoodsList.add(goods.getId());
					returnGoodsNumberList.add(goodsNumber);
				} else{
					for (int i = 0; i < returnGoodsList.size(); i++) {
						// 如果购物车已存在该商品
						if (returnGoodsList.get(i) == goods.getId()) {
							a = true;
							b = i;
							System.out.println(b + "   ytuyuty");
						} 
					}

					if (a != true) {
						returnGoodsList.add(goods.getId());
						returnGoodsNumberList.add(goodsNumber);

					} else {
						if((returnGoodsNumberList.get(b) + goodsNumber) > orderDetailGoodsNum){
							data.put("statusCode", "300");
							data.put("message", "请输入正确的退货数量！");
							return "goodsNumError";
						}
						returnGoodsNumberList.set(b, returnGoodsNumberList.get(b)
								+ goodsNumber);
					}
				}
				
				session.removeAttribute("returnGoodsNumberList");
				session.setAttribute("returnGoodsNumberList", returnGoodsNumberList);

				session.removeAttribute("returnGoodsList");
				session.setAttribute("returnGoodsList", returnGoodsList);
				
				// 遍历商品id，找出商品
				goodsNameList = new ArrayList<GoodsEntity>();
				for (int i = 0; i < returnGoodsList.size(); i++) {
					goodsNameList.add(goodsService.findGoodsById(returnGoodsList.get(i)));
				}
				session.removeAttribute("goodsNameList");
				session.setAttribute("goodsNameList", goodsNameList);
				
				data.put("statusCode", 200);
				data.put("message", "添加成功");
				data.put("navTabId", "returnGoods");
				data.put("rel", "");
				data.put("callbackType", "forward");
				data.put("forwardUrl", "goodsReturn.action");
				return "goodsReturnDetailAdd";
			}
			else{
				data.put("statusCode", "300");
				data.put("message", "请输入正确的退货数量！");
				return "goodsNumError";
			}
		}
		else {
		}
		
		return "goodsReturnDetailAdd";
	}
	
	public String goods_return(){
		
		return "goods_return";
	}
}
