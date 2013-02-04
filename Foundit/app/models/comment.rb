class Comment < ActiveRecord::Base
  belongs_to :user
  attr_accessible :body, :commenter
end
