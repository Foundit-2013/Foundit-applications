class PostingsController < ApplicationController
  # GET /postings
  # GET /postings.json
  def index
    @postings = Posting.all
    
    #@postings = Posting.find(:all, :order => "name")
    @postings = Posting.find(:all, :order => "created_at DESC")

    respond_to do |format|
      #format.json { render json: @postings, :content_type => 'application/json'}
      #format.json  { render :json => @things.to_json(:include => { :photos => { :only => [:id, :url] } }) }
      format.json { render :json => @postings.to_json(:methods => [:photo_url_thumb, :photo_url_large, :created_at_formatted]), :content_type => 'application/json'}
      #@postings.to_json(:only => [:id,:name,:description,:posting_type], :methods => [:photo_url])
      #format.xml  { render :xml => @postings }
      format.html # index.html.erb
    end
  end

  #this is my test comment
  # GET /postings/1
  # GET /postings/1.json
  def show
    @posting = Posting.find(params[:id])

    respond_to do |format|
      format.json { render :json => @posting.to_json(:methods => [:photo_url_thumb, :photo_url_large]), :content_type => 'application/json'}
      #format.json { render json: @posting }
      format.html # show.html.erb
    end
  end
  
  # GET /postings_show_lost
  # GET /postings_show_lost.json
  def show_lost
    #@posting = Posting.find(params[:id])
    @postings = Posting.where('posting_type == 1')
    @postings = @postings.find(:all, :order => "created_at DESC")

    respond_to do |format|
      format.json { render :json => @postings.to_json(:methods => [:photo_url_thumb, :photo_url_large, :created_at_formatted]), :content_type => 'application/json'}
      #format.json { render json: @postings }
      format.html { render action: "show_lost" }
    end
  end
  
  # GET /postings_show_found
  # GET /postings_show_found.json
  def show_found
    #@posting = Posting.find(params[:id])
    @postings = Posting.where('posting_type == 2')
    @postings = @postings.find(:all, :order => "created_at DESC")

    respond_to do |format|
      format.json { render :json => @postings.to_json(:methods => [:photo_url_thumb, :photo_url_large, :created_at_formatted]), :content_type => 'application/json'}
      #format.json { render json: @postings }
      format.html { render action: "show_found" }
    end
  end
  
  # GET /postings/new
  # GET /postings/new.json
  def new
    @posting = Posting.new

    respond_to do |format|
      format.json { render json: @posting }
      format.html # new.html.erb
    end
  end

  # GET /posting/1/edit
  def edit
    @posting = Posting.find(params[:id])
  end

  # Posting /posting
  # Posting /posting.json
  def create
    @posting = Posting.new(params[:posting])

    respond_to do |format|
      if @posting.save
        format.json { render json: @posting, status: :created, location: @posting }
        format.html { redirect_to @posting, notice: 'Posting was successfully created.' }
      else
        format.json { render json: @posting.errors, status: :unprocessable_entity }
        format.html { render action: "new" }
      end
    end
  end

  # PUT /postings/1
  # PUT /postings/1.json
  def update
    @posting = Posting.find(params[:id])

    respond_to do |format|
      if @posting.update_attributes(params[:posting])
        format.json { head :no_content }
        format.html { redirect_to @posting, notice: 'Posting was successfully updated.' }
      else
        format.json { render json: @posting.errors, status: :unprocessable_entity }
        format.html { render action: "edit" }
      end
    end
  end

  # DELETE /postings/1
  # DELETE /postings/1.json
  def destroy
    @posting = Posting.find(params[:id])
    #@Posting = Posting.where(name: params[:name])
    @posting.destroy

    respond_to do |format|
      format.json { head :no_content }
      format.html { redirect_to postings_url }
    end
  end
  
  # DELETE /postings/1
  # DELETE /postings/1.json
  def test
    @posting = Posting.find(params[:id])
    #@Posting = Posting.where(name: params[:name])
    @posting.destroy

    respond_to do |format|
      format.json { head :no_content }
      format.html { redirect_to postings_url }
    end
  end
end
