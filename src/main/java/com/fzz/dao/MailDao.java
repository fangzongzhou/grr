package com.fzz.dao;

import com.fzz.entity.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by huayu on 2017/5/26.
 */
public interface MailDao extends JpaRepository<Mail,Integer> {
}
