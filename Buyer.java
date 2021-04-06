package team4;

import java.util.*;

public class Buyer extends Manager{

	static List<String>list1 = new ArrayList<String>(); //제품 담는 배열
	static String [] buyNo = new String [1]; //고객번호 담을 배열
	static String[] buyerName = new String [1]; //고객명 담을 배열
	static String buyerInput; //고객명 비교변수
	static String customerTel; //고객번호 조회
	static int numbuyer = 0; //고객번호 증가

	static List<String> buySoup = new ArrayList<String>(); //구매 국명 차례로 담기
	static List<String> buySide = new ArrayList<String>(); //구매 반찬명 차례로 담기
	static List<Integer> priceSp = new ArrayList<Integer>(); //구매 국가격 차례로 담기
	static List<Integer> priceSe = new ArrayList<Integer>(); //구매 반찬가격 차례로 담기 
	static int totalNum = 0; //고객이 구매를 한 횟수
	static int soupNum = 0; //국을 구매한 횟수
	static int sideNum = 0; //반찬을 구매한 횟수

	static String productName; //구매 제품명
	static int productCount; //제품 구매 수량

	static int money = 0; //고객 소지 금액
	static int change = 0; //고객 잔돈 
	static int point; //포인트 
	static int[] pointTotal = new int[1];
	static double rate; //고객이 평가한 평점
	static double[] rating = new double[1];//평가하기 점수

	static String yesOrNo = null; //계속 구매 여부

	static boolean run = true; //반복문 변수
	static boolean flag = true; //반복문 변수2

	static int buyerSum = 0; //총 구매금액 

	static int num = 0; //Test
	static boolean tt = true; //Test2
	static int num2 = 0; //평점변수

	public static void buyerMode() { //고객 메인화면

		Manager manager = new Manager();

		System.out.println(" [ 고객 모드  ] ");
		System.out.println("1. 등록");
		System.out.println("2. 구매");
		System.out.println("3. 조회");
		System.out.println("4. 종료");
		System.out.print("선택 >");
		int select = Business.sc.nextInt();

		switch(select) {
		case 1: buyerNumber(); break;
		case 2: buyerPurchase(); break;
		case 3: buyerSearch(); break;
		case 4: manager.start(); break;
		default : System.out.println("다시 입력해주세요"); buyerMode(); break;
		}
	}

	public static void buyerNumber() { //고객번호 등록화면

		System.out.println("[ 신규고객 등록화면  ]");
		System.out.println("고객님의 이름을 입력해주세요.");
		System.out.print("입력 >");
		buyerInput = Business.sc.next();

		if(buyerInput.equals(buyerName[0])) {
			System.out.println("이미 등록된 고객입니다.");
			System.out.println();
			buyerMode();
		} else {
			buyerName[0] = buyerInput;	
			System.out.println("고객님의 휴대번호 뒷자리 4개를 입력해주세요.");
			System.out.print("입력 >");
			buyNo[0] = Business.sc.next();

			System.out.println("신규 고객으로 등록되셨습니다 !!!");
			System.out.println();
			buyerMode();
		}
	}

	public static void buyerPurchase() { //구매화면

		System.out.println("신규 고객 중 고객 등록을 원하시면 숫자 3번을 입력해주시고,");
		System.out.println("등록을 원하지 않으시다면 '0000'을 입력하여 진행해 주세요.");
		System.out.println("고객번호를 입력해주세요.");
		System.out.print("입력 >");

		try { //문자가 아닌 다른 글자를 입력했을 때 예외처리
			customerTel = Business.sc.next();
		} catch(InputMismatchException e) {
			System.err.println("비정상적인 접근입니다. 시스템을 다시 시작해 주세요.");
			System.exit(0);
		}

		if(customerTel.equals(buyNo[0])) {

			System.out.println();
			System.out.println(buyerName[0] + "고객님 저희 반찬가게를 방문해주셔서 감사합니다!");
			System.out.println();

		} else if (customerTel .equals("0000")) { 
			buyNo[0] = "0000";
            buyerName[0] = "미등록";
            System.out.println();
            System.out.println(buyerName[0] +"고객님 저희 반찬가게를 방문해주셔서 감사합니다!");
            System.out.println();

		} else if(customerTel.equals("3")) { 
			buyerNumber();
		} else {
			System.out.println("번호를 다시 입력해 주시기 바랍니다.");
			buyerMode();
		}

		System.out.println("                    [ 구매 모드  ]                   ");
		System.out.println();
		System.out.println("----------------------------------------------------------");
		System.out.println("|     메뉴명          |      남은 수량           |      가격           |");
		System.out.println("----------------------------------------------------------");

		for(int i = 0; i <  soupAmount.length; i++) {
			if(Manager.soupName.size()== 0) {
				System.out.println("상품입고안됨");
				buyerMode();
			}else {
				System.out.println("\t" + Manager.soupName.get(i) + "\t\t" + Manager.rest1[i] + "개" + "\t\t" + Manager.soupPrice[i]+"원");
			}
		}

		System.out.println("---------------------------------------------------------");

		for(int i = 0; i < soupAmount.length; i++) {
			if(Manager.sideName.size() == 0) {
				System.out.println("상품입고안됨");
				buyerMode();
			}else {
				System.out.println("\t" + Manager.sideName.get(i) + "\t\t" + Manager.rest2[i] + "개" + "\t\t" + Manager.sidePrice[i]+"원");
			}
		}


		if(flag) {
			System.out.println("현재 소지금액을 입력해주세요.");
			System.out.print("입력 >");
			change = Business.sc.nextInt();
			flag = false;
		}

		while(run) {

			//구매화면 반복
			System.out.println("[구매하기]  1. 국류 | 2. 반찬  | 3. 돌아가기");
			System.out.print("선택 >");
			int select = Business.sc.nextInt();
			int i;

			switch(select) {
			case  1 :
				
				System.out.println();
				System.out.println("----------------------------------------------------------");
				System.out.println("|     메뉴명          |      남은 수량           |      가격           |");
				System.out.println("----------------------------------------------------------");

				for( i = 0; i < soupAmount.length; i++) {
					System.out.println("\t" + Manager.soupName.get(i) + "\t\t" + Manager.rest1[i]+ "개" + "\t\t" + Manager.soupPrice[i]+"원");
				}

				System.out.println("구매하실 상품명을 입력해주세요.");
				System.out.print("입력 >");
				productName = Business.sc.next();

				System.out.println("구매하실 상품의 수량을 입력해주세요.");
				System.out.print("입력 >");
				productCount = Business.sc.nextInt();

				for(int j = 0; j<soupAmount.length; j++) {

					if(productName.equals(Manager.soupName.get(j))){

						num = j;
						tt = false;
						break;

					}

				}//for 끝

				if(tt) {
					System.out.println("해당상품은 저희가게에 없습니다.");
					break;
				}else if(Manager.rest1[num] < productCount) {
					System.out.println("재고가 부족합니다.");
					buyerMode();
					break;

				}else if(change < (Manager.soupPrice[num]* productCount)){
					System.out.println("고객님의 잔액이 부족합니다.");
					buyerMode();
				}else {						
					Manager.rest1[num]-=productCount;
					change -= Manager.soupPrice[num] * productCount;
					buyerSum += Manager.soupPrice[num] * productCount;
					point += Manager.soupPrice[num] * 0.03;
					pointTotal[0] = point;

					buySoup.add(productName);
					priceSp.add(productCount);
					soupNum++;
					totalNum++;
					num = 0;
					tt = true;
					System.out.println("구매완료 !!!");

				}

				System.out.println("계속 구매하시겠습니까?");
				System.out.print("입력(Y/N) >");
				String ys = Business.sc.next();
				if(ys.equals("n") || ys.equals("N")) {
					point();
					buyerMode();
					//buyerMode(); 이걸 하면 재구매 안하는데 메뉴판이 떠버려서 주석처리했어요.
				}else if(ys.equals("y") || ys.equals("Y")) {
					run = true; 
					// ↑ buyerPurchase() 재구매시에 핸드폰번호를 다시 물어보는것부터 시작해서 어자피 같은 사람이 구매하는거라 불필요한 과정같아서 변경했어요.
				}else {
					System.out.println("잘못된 입력입니다. 다시 입력해 주세요."); break;
				}
				break;
				//반찬
			case 2 :
				
				
				System.out.println();
				System.out.println("----------------------------------------------------------");
				System.out.println("|     메뉴명          |      남은 수량           |      가격           |");
				System.out.println("----------------------------------------------------------");

				for( i = 0; i < soupAmount.length; i++) {
					System.out.println("\t" + Manager.sideName.get(i) + "\t\t" + Manager.rest2[i]+ "개" + "\t\t" + Manager.sidePrice[i]+"원");
				}

				System.out.println("구매하실 상품명을 입력해 주세요.");
				System.out.print("입력 >");
				productName = Business.sc.next();

				System.out.println("구매하실 상품의 수량을 입력해 주세요. ");
				System.out.print("입력 >");
				productCount = Business.sc.nextInt();

				for(int j = 0; j<sideAmount.length; j++) {

					if(productName.equals(Manager.sideName.get(j))){

						num = j;
						tt = false;
						break;

					}

				}//for 끝

				if(tt) {
					System.out.println("해당상품은 저희가게에 없습니다.");
					break;
				}else if(Manager.rest2[num] < productCount) {
					System.out.println("재고가 부족합니다.");
					buyerMode();
					break;

				}else if(change < (Manager.sidePrice[num]* productCount)){
					System.out.println("고객님의 잔액이 부족합니다.");
					buyerMode();
				}else {						
					Manager.rest2[num]-=productCount;
					change -= Manager.sidePrice[num] * productCount;
					buyerSum += Manager.sidePrice[num] * productCount;
					point += Manager.sidePrice[num] * 0.02;
					pointTotal[0] = point;

					buySide.add(productName);
					priceSe.add(productCount);
					sideNum++;
					totalNum++;
					num = 0;
					tt = true;
					System.out.println("구매완료 !!!");

				}

				System.out.println("계속 구매하시겠습니까?");
				System.out.print("입력(Y/N) >");
				ys = Business.sc.next();

				if(ys.equals("y") || ys.equals("Y")) {
					run = true;
					//buyerMode(); 이걸 하면 재구매 안하는데 메뉴판이 떠버려서 주석처리했어요.
				}else if(ys.equals("n") || ys.equals("N")) {
					point();
					buyerMode();
					// ↑ buyerPurchase() 재구매시에 핸드폰번호를 다시 물어보는것부터 시작해서 어자피 같은 사람이 구매하는거라 불필요한 과정같아서 변경했어요.
				}else {
					System.out.println("잘못된 입력입니다. 다시 입력해 주세요."); break;
				}
				break;

			case 3 :
				buyerMode();
				break;

			default : 
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
				buyerPurchase(); 
				break;
			} //switch문 끝
		} //while문 끝

		//포인트 적립 화면
	}
	public static void point() {

		System.out.println("                  [ 계산 화면  ]                   ");
		System.out.println("고객님이 구매하신 금액은 " + buyerSum + "원 입니다.");
		System.out.println("잔돈 " + change  + "원 입니다.");

		if(customerTel.equals("0000")) {
			System.out.println("===============================================");
		}else if(customerTel.equals(buyNo[0])) {
			System.out.println(pointTotal[0] + " 포인트가 적립되었습니다.");
		} else {
			System.out.println();
		}

		if(buyNo[0].equals("0000")) {
			System.out.println("* 이용해 주셔서 감사합니다. *");
		}else {
			//평가 화면
			System.out.println("                [ 평가 화면 ]                   ");
			System.out.println("본 반찬가게에 대해 고객님의 평가를 받고 있습니다.");
			System.out.println("평가를 희망하시는 경우 Y를 희망하지 않으면 N을 눌러주세요.");
			System.out.print("입력 (Y/N) >");
			yesOrNo = Business.sc.next();

			if(yesOrNo.equals("Y") | yesOrNo.equals("y")) {

				System.out.println("평가에 참여해주셔서 감사합니다. 평가 부탁드립니다.");
				System.out.println(" 5. 아주 좋았다 " + "\t\t" + " 4. 좋았다. " + "\t\t" + " 3. 보통이다. " + "\t\t" + " 2. 별로였다. " + "\t\t" + " 1. 매우 별로였다. ");
				System.out.print("평가 입력 (1~5) >");
				rate = Business.sc.nextInt();
				num2++;
				rating[0] += rate;

				System.out.println("고객님의 소중한 의견 감사합니다.");
				System.out.println("* 이용해 주셔서 감사합니다. *");

			} else if(yesOrNo.equals("N") | yesOrNo.equals("n")) {
				System.out.println("* 이용해 주셔서 감사합니다. *");
			} else {
				System.out.println("y 또는 n을 입력하여 주시기 바랍니다.");
			}
		}

	}

	public static void buyerSearch() { //고객 조회화면

		System.out.print("고객님의 휴대폰번호 뒷자리 4개를 입력해 주세요. >");
		customerTel = Business.sc.next();
		if(customerTel.equals("0000")) {
			System.out.println("등록된 회원만 조회할 수 있습니다.");
		}else	if(customerTel.equals(buyNo[0])) {

			System.out.println("[고객 No." + buyNo[0] +"]");
			System.out.println(buyerName[0] + " 고객님 반갑습니다.");
			System.out.println();

			//조회 부분
			if(totalNum == 0) {
				System.out.println(" 고객님의 구매내역은 비어있습니다 구매하러 가볼까요~? ");
				System.out.println();
				buyerMode(); //조회 후 고객모드로 돌아옴
			} else {
				
				System.out.println(" [ 고객 조회  ] ");

				if(soupNum == 0) { //고객이 국을 구매하지 않았다면 
					System.out.println("국은 구매하지 않으셨습니다.");
					System.out.println();
				} else {
					for(int i = 0; i<soupNum; i++) { //고객이 국을 구매했다면
						System.out.println("구매 국명: " + buySoup.get(i) +"\t" + "구매 개수: " + priceSp.get(i)+ "개");
					}	
					System.out.println("=========================================================================");
				}
				if(sideNum == 0) { //고객이 반찬을 구매하지 않았다면
					System.out.println("반찬은 구매하지 않으셨습니다.");
					System.out.println();
				} else {
					for(int i = 0; i<sideNum; i++) { //고객이 반찬을 구매했다면
						System.out.println("구매 반찬명: " + buySide.get(i) +"\t" + "구매 개수: " + priceSe.get(i)+ "개");
						System.out.println();
					}
				}
				System.out.println("=========================================================================");
				System.out.println("고객님의 총 구매금액은 " + buyerSum + "원 이며 잔액은 " + change + "원 입니다.");
				System.out.println("고객님의 잔여포인트는 " + pointTotal[0] + "점 입니다.");
				System.out.println(" * 이용해주셔서 감사합니다. * ");

				System.out.println();
				buyerMode(); //조회 후 고객모드로 돌아옴
			}
		} 
	}
}
