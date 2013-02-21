# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rake db:seed (or created alongside the db with db:setup).
#
# Examples:
#
#   cities = City.create([{ name: 'Chicago' }, { name: 'Copenhagen' }])
#   Mayor.create(name: 'Emanuel', city: cities.first)

Posting.delete_all

#c = Posting.all
#c.each do |cat|
#  puts "Posting.create(:id => '#{cat.id}', :posting_type => '#{cat.posting_type}', :name => '#{cat.name}', :description => '#{cat.description}', :created_at => '#{cat.created_at}', :updated_at => '#{cat.updated_at}', :photo_file_name => '#{cat.photo_file_name}', :photo_content_type => '#{cat.photo_content_type}', :photo_file_size => '#{cat.photo_file_size}', :photo_updated_at => '#{cat.photo_updated_at}')"
#end           
             
Posting.create(:id => '1', :posting_type => '1', :name => 'Pikachu', :description => 'It evolves from Pichu when leveled up with high friendship and evolves into Raichu when exposed to a Thunderstone. Pikachu is popularly known as the mascot of the Pokemon franchise and a major representative of Nintendo\'s collective mascots. It is also the version mascot of Pokemon Yellow, where it is the only starter Pokemon in that game. It has also made numerous appearances on the boxes of spin-off titles.', :created_at => '2013-02-18 02:00:39 UTC', :updated_at => '2013-02-18 02:00:39 UTC', :photo_file_name => '190px-025Pikachu.png', :photo_content_type => 'image/png', :photo_file_size => '31', :photo_updated_at => '2013-02-18 02:00:39 UTC')

Posting.create(:id => '2', :posting_type => '1', :name => 'shaun', :description => 'lost my puppy', :created_at => '2013-02-18 02:21:31 UTC', :updated_at => '2013-02-18 02:21:31 UTC', :photo_file_name => 'puppies-2.jpg', :photo_content_type => 'image/jpeg', :photo_file_size => '28', :photo_updated_at => '2013-02-18 02:21:31 UTC')

Posting.create(:id => '3', :posting_type => '1', :name => 'Shaun3424', :description => 'Lost My Abra... It Teleported away from me. Please contact me if found.', :created_at => '2013-02-18 02:22:30 UTC', :updated_at => '2013-02-18 02:22:30 UTC', :photo_file_name => '200px-063Abra.png', :photo_content_type => 'image/png', :photo_file_size => '33394', :photo_updated_at => '2013-02-18 02:22:29 UTC')

Posting.create(:id => '4', :posting_type => '2', :name => 'asdfsdf', :description => 'Found a Typhlosion. If not claimed within 24Hrs I\'m keeping it!', :created_at => '2013-02-18 02:22:56 UTC', :updated_at => '2013-02-18 02:22:56 UTC', :photo_file_name => 'ani157.gif', :photo_content_type => 'image/gif', :photo_file_size => '20221', :photo_updated_at => '2013-02-18 02:22:56 UTC')

Posting.create(:id => '5', :posting_type => '1', :name => 'Gary Oak', :description => 'Lost my iPod. It was stolen by Team Rocket', :created_at => '2013-02-18 02:23:41 UTC', :updated_at => '2013-02-18 02:23:41 UTC', :photo_file_name => '2012-ipodtouch-product-initial.png', :photo_content_type => 'image/png', :photo_file_size => '118211', :photo_updated_at => '2013-02-18 02:23:41 UTC')

Posting.create(:id => '6', :posting_type => '1', :name => 'Bulbasaur', :description => 'A strange seed was planted on its back at birth. The plant sprouts and grows with this POKeMON.', :created_at => '2013-02-18 02:50:48 UTC', :updated_at => '2013-02-18 02:50:48 UTC', :photo_file_name => 'bulbasaur.jpg', :photo_content_type => 'image/jpeg', :photo_file_size => '40983', :photo_updated_at => '2013-02-18 02:50:48 UTC')

Posting.create(:id => '7', :posting_type => '1', :name => 'Celebi', :description => 'This POKeMON came from the future by crossing over time. It is thought that so long as CELEBI appears, a bright and shining future awaits us.', :created_at => '2013-02-18 02:52:07 UTC', :updated_at => '2013-02-18 02:52:07 UTC', :photo_file_name => 'celebi.jpg', :photo_content_type => 'image/jpeg', :photo_file_size => '29855', :photo_updated_at => '2013-02-18 02:52:07 UTC')

Posting.create(:id => '8', :posting_type => '2', :name => 'Jigglypuff', :description => 'Looking into its cute, round eyes makes it start singing a song so pleasant listeners can\'t help but fall asleep.', :created_at => '2013-02-18 02:53:12 UTC', :updated_at => '2013-02-18 02:53:12 UTC', :photo_file_name => 'jigglypuff.jpg', :photo_content_type => 'image/jpeg', :photo_file_size => '29759', :photo_updated_at => '2013-02-18 02:53:12 UTC')

Posting.create(:id => '9', :posting_type => '1', :name => 'Magikarp', :description => 'An underpowered, pathetic Pokemon. It may jump high on rare occasions, but usually not more than seven feet.', :created_at => '2013-02-18 02:55:14 UTC', :updated_at => '2013-02-18 02:55:14 UTC', :photo_file_name => 'magikarp.jpg', :photo_content_type => 'image/jpeg', :photo_file_size => '28742', :photo_updated_at => '2013-02-18 02:55:14 UTC')

Posting.create(:id => '10', :posting_type => '2', :name => 'Deoxys', :description => 'DNA from a space virus mutated and became a Pokemon. It appears where auroras are seen.', :created_at => '2013-02-18 02:55:56 UTC', :updated_at => '2013-02-18 02:55:56 UTC', :photo_file_name => 'deoxys-normal.jpg', :photo_content_type => 'image/jpeg', :photo_file_size => '34750', :photo_updated_at => '2013-02-18 02:55:56 UTC')

Posting.create(:id => '11', :posting_type => '2', :name => 'Charizard', :description => 'It spits fire that is hot enough to melt boulders. It may cause forest fires by blowing flames.', :created_at => '2013-02-18 02:56:55 UTC', :updated_at => '2013-02-18 02:56:55 UTC', :photo_file_name => 'charizard.jpg', :photo_content_type => 'image/jpeg', :photo_file_size => '35166', :photo_updated_at => '2013-02-18 02:56:55 UTC')
   
puts "Success: Postings data loaded"
