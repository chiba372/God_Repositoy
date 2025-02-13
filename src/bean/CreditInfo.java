package bean;

public class CreditInfo {
    private String cardNumber;
    private String cardName;
    private int expiryMonth;
    private int expiryYear;
    private int securityCode;

    // コンストラクタ
    public CreditInfo() {}

    public CreditInfo(String cardNumber, String cardName, int expiryMonth, int expiryYear, int securityCode) {
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.securityCode = securityCode;
    }

    // ゲッター・セッター
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(int expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public int getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(int expiryYear) {
        this.expiryYear = expiryYear;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

	public void setSecurityCode(String securityCode2) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void setExpiryYear(String expiryYear2) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void setExpiryMonth(String expiryMonth2) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public String getMaskedCardNumber() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
