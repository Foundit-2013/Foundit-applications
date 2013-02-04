class UsersController < ApplicationController
  # GET /users
  # GET /users.json
  def index
    @users = User.all

    respond_to do |format|
      format.json { render json: @users }
      format.html # index.html.erb
    end
  end

  # GET /users/1
  # GET /users/1.json
  def show
    @user = User.find(params[:id])

    respond_to do |format|
      format.json { render json: @user }
      format.html # show.html.erb
    end
  end

  # GET /user/new
  # GET /user/new.json
  def new
    @user = User.new

    respond_to do |format|
      format.json { render json: @user }
      format.html # new.html.erb
    end
  end

  # GET /user/1/edit
  def edit
    @user = User.find(params[:id])
  end

  # User /user
  # User /user.json
  def create
    @user = User.new(params[:user])

    respond_to do |format|
      if @user.save
        format.json { render json: @user, status: :created, location: @user }
        format.html { redirect_to @user, notice: 'User was successfully created.' }
      else
        format.json { render json: @user.errors, status: :unprocessable_entity }
        format.html { render action: "new" }
      end
    end
  end

  # PUT /users/1
  # PUT /users/1.json
  def update
    @user = User.find(params[:id])

    respond_to do |format|
      if @user.update_attributes(params[:user])
        format.json { head :no_content }
        format.html { redirect_to @user, notice: 'User was successfully updated.' }
      else
        format.json { render json: @user.errors, status: :unprocessable_entity }
        format.html { render action: "edit" }
      end
    end
  end

  # DELETE /users/1
  # DELETE /users/1.json
  def destroy
    @user = User.find(params[:id])
    #@User = User.where(name: params[:name])
    @user.destroy

    respond_to do |format|
      format.json { head :no_content }
      format.html { redirect_to users_url }
    end
  end
end
