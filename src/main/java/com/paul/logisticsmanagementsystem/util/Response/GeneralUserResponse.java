package com.paul.logisticsmanagementsystem.util.Response;

import com.github.pagehelper.PageInfo;
import com.paul.logisticsmanagementsystem.entity.*;

import java.util.*;
/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 4/7/2018
 * Time: 5:10 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
public class GeneralUserResponse  extends  Response{
    private  VoiceMail voiceMail;
    private Traces traces;
    private  Orders orders;
    private GeneralUser generalUser;
    private VoiceMailDetail voiceMailDetail;
    private  CompleteOrder completeOrder;
    private List<Traces> allTraces;
    private List<TracesReservation> allTracesReservation;
    private List<CompleteOrder> allCompleteOrders;
    private PageInfo<GeneralUser> page;
    private PageInfo<VoiceMail>  pageVoiceMails;
    private PageInfo<VoiceMailDetail> pageVoiceMail;
    private PageInfo<Orders> pageOrders;
    private PageInfo<CompleteOrder> pageCompleteOrders;
    private PageInfo<Traces>  pageTraces;
    private PageInfo<TracesReservation>  pageTraceReservations;
    private PageInfo<OrderReservation>  pageReservations;
    private OrderReservation orderReservation;
    private TracesReservation tracesReservation;
    private PageInfo<Commodity> pageCommodity;
    private PageInfo<CompleteCommodity> pageCompleteCommodity;
    private CompleteCommodity completeCommodity;
    private  News news;
    private  PageInfo<News> pageNews;
    private List<News> newsList;

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public PageInfo<News> getPageNews() {
        return pageNews;
    }

    public void setPageNews(PageInfo<News> pageNews) {
        this.pageNews = pageNews;
    }

    public CompleteCommodity getCompleteCommodity() {
        return completeCommodity;
    }
    public void setCompleteCommodity(CompleteCommodity completeCommodity) {
        this.completeCommodity = completeCommodity;
    }

    public PageInfo<CompleteCommodity> getPageCompleteCommodity() {
        return pageCompleteCommodity;
    }

    public void setPageCompleteCommodity(PageInfo<CompleteCommodity> pageCompleteCommodity) {
        this.pageCompleteCommodity = pageCompleteCommodity;
    }

    public PageInfo<Commodity> getPageCommodity() {
        return pageCommodity;
    }


    public void setPageCommodity(PageInfo<Commodity> pageCommodity) {
        this.pageCommodity = pageCommodity;
    }

    public TracesReservation getTracesReservation() {
        return tracesReservation;
    }

    public void setTracesReservation(TracesReservation tracesReservation) {
        this.tracesReservation = tracesReservation;
    }

    public PageInfo<TracesReservation> getPageTraceReservations() {
        return pageTraceReservations;
    }

    public void setPageTraceReservations(PageInfo<TracesReservation> pageTraceReservations) {
        this.pageTraceReservations = pageTraceReservations;
    }

    public List<TracesReservation> getAllTracesReservation() {
        return allTracesReservation;
    }

    public void setAllTracesReservation(List<TracesReservation> allTracesReservation) {
        this.allTracesReservation = allTracesReservation;
    }

    public OrderReservation getOrderReservation() {
        return orderReservation;
    }

    public void setOrderReservation(OrderReservation orderReservation) {
        this.orderReservation = orderReservation;
    }

    public PageInfo<OrderReservation> getPageReservations() {
        return pageReservations;
    }

    public void setPageReservations(PageInfo<OrderReservation> pageReservations) {
        this.pageReservations = pageReservations;
    }

    public PageInfo<VoiceMail> getPageVoiceMails() {
        return pageVoiceMails;
    }

    public void setPageVoiceMails(PageInfo<VoiceMail> pageVoiceMails) {
        this.pageVoiceMails = pageVoiceMails;
    }

    public VoiceMail getVoiceMail() {
        return voiceMail;
    }

    public void setVoiceMail(VoiceMail voiceMail) {
        this.voiceMail = voiceMail;
    }

    public List<CompleteOrder> getAllCompleteOrders() {
        return allCompleteOrders;
    }

    public void setAllCompleteOrders(List<CompleteOrder> allCompleteOrders) {
        this.allCompleteOrders = allCompleteOrders;
    }

    public Traces getTraces() {
        return traces;
    }

    public void setTraces(Traces traces) {
        this.traces = traces;
    }

    public PageInfo<Traces> getPageTraces() {
        return pageTraces;
    }

    public void setPageTraces(PageInfo<Traces> pageTraces) {
        this.pageTraces = pageTraces;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public GeneralUser getGeneralUser() {
        return generalUser;
    }

    public void setGeneralUser(GeneralUser generalUser) {
        this.generalUser = generalUser;
    }

    public PageInfo<GeneralUser> getPage() {
        return page;
    }

    public void setPage(PageInfo<GeneralUser> page) {
        this.page = page;
    }

    public PageInfo<VoiceMailDetail> getPageVoiceMail() {
        return pageVoiceMail;
    }

    public void setPageVoiceMail(PageInfo<VoiceMailDetail> pageVoiceMail) {
        this.pageVoiceMail = pageVoiceMail;
    }

    public VoiceMailDetail getVoiceMailDetail() {
        return voiceMailDetail;
    }

    public void setVoiceMailDetail(VoiceMailDetail voiceMailDetail) {
        this.voiceMailDetail = voiceMailDetail;
    }

    public PageInfo<Orders> getPageOrders() {
        return pageOrders;
    }

    public void setPageOrders(PageInfo<Orders> pageOrders) {
        this.pageOrders = pageOrders;
    }

    public List<Traces> getAllTraces() {
        return allTraces;
    }

    public void setAllTraces(List<Traces> allTraces) {
        this.allTraces = allTraces;
    }

    public CompleteOrder getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(CompleteOrder completeOrder) {
        this.completeOrder = completeOrder;
    }

    public PageInfo<CompleteOrder> getPageCompleteOrders() {
        return pageCompleteOrders;
    }

    public void setPageCompleteOrders(PageInfo<CompleteOrder> pageCompleteOrders) {
        this.pageCompleteOrders = pageCompleteOrders;
    }
}
