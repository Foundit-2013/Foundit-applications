require 'test_helper'

class PostingTest < ActiveSupport::TestCase
  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:postings)
  end
end
