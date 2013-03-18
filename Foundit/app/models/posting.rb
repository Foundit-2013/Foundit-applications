class Posting < ActiveRecord::Base
  attr_accessible :name, :description, :posting_type
  
  def asset?
    !(asset_content_type =~ /^image.*/).nil?
  end
  
  attr_accessible :id, :created_at, :updated_at, :photo_file_name, :photo_content_type, :photo_file_size, :photo_updated_at
  
  attr_accessible :photo
  has_attached_file :photo,
  :styles => { :large => "300x300>", :thumb => "60x60>" }, 
  #:url => "/system/:class/:attachment/:id/:style/:basename.:extension",
  #:path => ":rails_root/images"
  :path => ":rails_root/public/system/:class/:attachment/:id_partition/:style/:filename"
  
  def photo_url_large
    photo.url(:large)
    #photo.path(:large)
  end
  
  def photo_url_thumb
    photo.url(:thumb)
    #photo.path(:thumb)
  end
  
  def created_at_formatted
    created_at.strftime("%d-%b-%Y %H:%M" )
  end
  
  validates :name, :presence => true, :length => { :in => 3..20 }
  validates :description, :presence => true, :length => { :minimum => 10 }
  validates :posting_type, :presence => true

end
