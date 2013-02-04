require 'test_helper'

class UsersControllerTest < ActionController::TestCase
  setup do
    @user = users(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:users)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create user" do
    assert_difference('User.count') do
      user :create, user: { content: @user.content, name: @user.name, title: @user.title }
    end

    assert_redirected_to user_path(assigns(:user))
  end

  test "should show user" do
    get :show, id: @user
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @user
    assert_response :success
  end

  test "should update user" do
    put :update, id: @user, user: { content: @user.content, name: @user.name, title: @user.title }
    assert_redirected_to user_path(assigns(:user))
  end

  test "should destroy user" do
    assert_difference('user.count', -1) do
      delete :destroy, id: @user
    end

    assert_redirected_to users_path
  end
end
