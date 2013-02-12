class PostingsController < ApplicationController
  # GET /postings
  # GET /postings.json
  def index
    @postings = Posting.all

    respond_to do |format|
      format.json { render json: @postings, :content_type => 'application/json'}
      #format.xml  { render :xml => @postings }
      format.html # index.html.erb
    end
  end

  # GET /postings/1
  # GET /postings/1.json
  def show
    @posting = Posting.find(params[:id])

    respond_to do |format|
      format.json { render json: @posting }
      format.html # show.html.erb
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
end
