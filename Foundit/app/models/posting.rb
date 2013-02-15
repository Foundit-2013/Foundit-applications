class Posting < ActiveRecord::Base
  attr_accessible :name, :description, :image, :image_thumb, :posting_type
  
  validates :name,  :presence => true, :length => { :in => 3..20 }
  validates :description, :presence => true, :length => { :minimum => 10 }
  validates :posting_type,  :presence => true

end
