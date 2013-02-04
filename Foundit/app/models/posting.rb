class Posting < ActiveRecord::Base
  attr_accessible :name, :description, :image, :posting_type
end
