package pojo.response.user.get_all_users;

public class Users {
	private String accountId;
	private AvatarUrls avatarUrls;
	private String displayName;
	private String accountType;
	private String self;
	private boolean active;
	private String locale;
	private String emailAddress;
	private String timeZone;

	public void setAccountId(String accountId){
		this.accountId = accountId;
	}

	public String getAccountId(){
		return accountId;
	}

	public void setAvatarUrls(AvatarUrls avatarUrls){
		this.avatarUrls = avatarUrls;
	}

	public AvatarUrls getAvatarUrls(){
		return avatarUrls;
	}

	public void setDisplayName(String displayName){
		this.displayName = displayName;
	}

	public String getDisplayName(){
		return displayName;
	}

	public void setAccountType(String accountType){
		this.accountType = accountType;
	}

	public String getAccountType(){
		return accountType;
	}

	public void setSelf(String self){
		this.self = self;
	}

	public String getSelf(){
		return self;
	}

	public void setActive(boolean active){
		this.active = active;
	}

	public boolean isActive(){
		return active;
	}

	public void setLocale(String locale){
		this.locale = locale;
	}

	public String getLocale(){
		return locale;
	}

	public void setEmailAddress(String emailAddress){
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress(){
		return emailAddress;
	}

	public void setTimeZone(String timeZone){
		this.timeZone = timeZone;
	}

	public String getTimeZone(){
		return timeZone;
	}
}
