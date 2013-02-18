class AddPhotoColumnsToPostings < ActiveRecord::Migration
  def self.up
    add_attachment :postings, :photo
  end

  def self.down
    remove_attachment :postings, :photo
  end
end