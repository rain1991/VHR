<template>
  <div>
    <el-container>
      <el-header style="padding: 0px;display:flex;justify-content:space-between;align-items: center">
        <div style="display: inline">
          <el-input
            placeholder="通过员工名搜索员工,记得回车哦..."
            clearable
            @change="keywordsChange"
            style="width: 300px;margin: 0px;padding: 0px;"
            size="mini"
            :disabled="advanceSearchViewVisible"
            @keyup.enter.native="searchEmp"
            prefix-icon="el-icon-search"
            v-model="keywords">
          </el-input>
          <el-button type="primary" size="mini" style="margin-left: 5px" icon="el-icon-search" @click="searchEmp">搜索</el-button>
        </div>
        <div style="margin-left: 5px;margin-right: 20px;display: inline">
          <el-button type="primary" size="mini" icon="el-icon-plus" @click="showAddEmpView">添加奖惩</el-button>
        </div>
      </el-header>
      <el-main style="padding-left: 0px;padding-top: 0px">
        <div>
          <el-table
            :data="emps"
            v-loading="tableLoading"
            border
            stripe
            @selection-change="handleSelectionChange"
            size="mini"
            style="width: 100%">
            <el-table-column
              type="selection"
              align="left"
              width="30">
            </el-table-column>
            <el-table-column
              prop="name"
              align="center"
              fixed
              label="姓名"
              width="90">
            </el-table-column>
            <el-table-column
              prop="workID"
              width="85"
              align="center"
              label="工号">
            </el-table-column>
            <el-table-column
              prop="type"
              align="center"
              fixed
              label="奖惩类型"
              width="85">
            </el-table-column>
            <el-table-column
              prop="amount"
              label="金额"
              width="50">
            </el-table-column>
            <el-table-column
              prop="reason"
              width="100"
              align="center"
              label="奖惩原因">
            </el-table-column>
            <el-table-column
              width="85"
              align="center"
              label="奖惩日期">
              <template slot-scope="scope">{{ scope.row.insertDate | formatDate}}</template>
            </el-table-column>
            <el-table-column
              prop="remake"
              width="100"
              align="center"
              label="备注">
            </el-table-column>
            <el-table-column
              fixed="right"
              label="操作"
              width="195">
              <template slot-scope="scope">
                <el-button @click="showEditEmpView(scope.row)" style="padding: 3px 4px 3px 4px;margin: 2px"
                           size="mini">编辑
                </el-button>
                <el-button type="danger" style="padding: 3px 4px 3px 4px;margin: 2px" size="mini"
                           @click="deleteEmp(scope.row)">删除
                </el-button>
              </template>
            </el-table-column>
          </el-table>
          <div style="display: flex;justify-content: space-between;margin: 2px">
            <el-pagination
              background
              :page-size="10"
              :current-page="currentPage"
              @current-change="currentChange"
              layout="prev, pager, next"
              :total="totalCount">
            </el-pagination>
          </div>
        </div>
      </el-main>
    </el-container>
  </div>
</template>
<script>
  export default{
    data() {
      return {
        emps: []
      }
    },
    mounted: function () {
      // this.initData();
      this.loadEmps();
    },
    methods: {
      loadEmps(){
        var _this = this;
        this.tableLoading = true;
        this.getRequest("/personnel/basic/incentive?page=1&size=10").then(resp=> {
          this.tableLoading = false;
        if (resp && resp.status == 200) {
          var data = resp.data;
          _this.emps = data.emps;
          _this.totalCount = data.count;
//            _this.emptyEmpData();
        }
      })
      }
    }
  };
</script>
