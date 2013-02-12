class CreatePostings < ActiveRecord::Migration
  def change
    create_table :postings do |t|
      t.text :posting_type
      t.string :name
      t.text :description
      t.string :image

      t.timestamps
    end
  end
end