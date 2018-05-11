package com.springboot.rabbitmq.entity;

public class RabbitmqConstant {

	public static interface MQ {
		/**
		 * 发送离线广告队列
		 */
		String SEND_OFFLINE_AD_DL_MQ = "send.offline.ad.DL.mq";// DL=Dead Letter

		String RECEIVE_OFFLINE_AD_DELAY_MQ = "receive.offline.ad.delay.mq";

		/**
		 * 相片打印重试队列
		 */
		String SEND_PHOTO_PRINT_DL_MQ = "send.photo.print.DL.mq";// DL队列

		String RECEIVE_PHOTO_PRINT_DELAY_MQ = "receive.photo.print.delay.mq";

		/**
		 * 文档打印重试队列
		 */
		String SEND_DOC_PRINT_DL_MQ = "send.doc.print.DL.mq";// DL队列

		String RECEIVE_DOC_PRINT_DELAY_MQ = "receive.doc.print.delay.mq";

		/**
		 * 上传七牛完成通知队列
		 */
		String DOC_UPLOAD_7NIU_FINISH_MQ = "doc.upload.7niu.finish.mq";

		/**
		 * 共享电视重试队列
		 */
		String SEND_TV_DL_MQ = "send.TV.DL.mq";// DL队列

		String RECEIVE_TV_DELAY_MQ = "receive.TV.delay.mq";
	}

	public static String Exchange = "RBMQ";
}
