class User < ActiveRecord::Base
  attr_accessible :password, :name, :email, :password_confirmation
  
  EMAIL_REGEX = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]{2,4}$/i
  
  validates :name,  :presence => true, :length => { :in => 3..20 }
  validates :password, :presence => true, :length => { :minimum => 5 }
  #validates :password_confirmation, :presence => true, :length => { :minimum => 5 }
  validates :email, :presence => true, :format => EMAIL_REGEX

  has_many :comments

    #class method that authenticates a user, used to create a session cookie
  def self.authenticate(email, submitted_password)
    user = find_by_email(email)
    return nil if user.nil?
    return user if user.has_password?(submitted_password)
  end

  #used to authenticate a signed user from a signed cookie 
  def self.authenticate_with_salt(id, cookie_salt)
    user = find_by_id(id)
    return nil if user.nil?
    return user if user.salt == cookie_salt
  end

  #callback that occurs before a record is successfully saved (meaning it has a valud password)                      
  #before_save :encrypt_password

  def has_password?(submitted_password)
    encrypted_password == encrypt(submitted_password)
  end

  private

    #self keyword is required when assigning to a instance attribute
    def encrypt_password      
      if password.present?
        self.salt = make_salt if new_record?
        self.encrypted_password = encrypt(password)
      end
    end

    def encrypt(string)
      secure_hash("#{salt}--#{string}")
    end

    def make_salt
      secure_hash("#{Time.now.utc}--#{password}")      
    end

    def secure_hash(string)
      Digest::SHA1.hexdigest(string)
    end
                    
end
