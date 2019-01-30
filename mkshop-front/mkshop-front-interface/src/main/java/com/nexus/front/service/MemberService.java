package com.nexus.front.service;


import com.nexus.common.model.ServerResponse;
import com.nexus.manager.dto.RegisterMember;
import com.nexus.manager.pojo.TbMember;

public interface MemberService {

    public TbMember testSelectByUsername(String username);

    public String hello(String words);

    public Integer insertMember(TbMember tbMember);

    public TbMember selectMember(long id);

    public TbMember selectMemberByName(String username);

    public Integer updateMember(TbMember tbMember);

    public Integer deleteMember(long id);

    public Integer changePwd(long id,String passwordNew);


}
