class CreatePosts < ActiveRecord::Migration
  def change
    create_table :posts do |t|
      t.string :name
      t.string :password
      t.string :email
      t.string :birthday

      t.timestamps
    end
  end
end
