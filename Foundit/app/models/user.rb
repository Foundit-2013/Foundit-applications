class User < ActiveRecord::Base
  attr_accessible :password, :name, :email
  
  validates :name,  :presence => true
  validates :password, :presence => true,
                    :length => { :minimum => 5 }

  has_many :comments
                    
end
